import React, { useEffect, useState  } from 'react';
import axios from 'axios';
import '../css/Home.css';
import { Link } from 'react-router-dom';

export default function Home() {

    const [users,setUsers] = useState([]);


    useEffect(()=>{
        loadUsers();
    },[]);

    const loadUsers=async()=>{
        const result = await axios.get("http://localhost:8080/getLogin")
        setUsers(result.data);
        console.log(result.data);
    };

  return (
    <div className="container">
        <div className="py-4">
        <table className="table border shadow">
  <thead>
    <tr>
      <th scope="col">S.No</th>
      <th scope="col">User ID</th>
      <th scope="col">User Name</th>
      <th scope="col">Password</th>
      <th scope="col">Actions</th>
    </tr>
  </thead>
  <tbody>

    {
        users.map((user,index)=>(
        <tr key={user.userId}>
        <th scope="row" key={index}>{index+1}</th>
        <td>{user.userId}</td>
        <td>{user.username}</td>
        <td>{user.password}</td>
        <td>
          <button className='btn btn-primary mx-2'>View</button>
          <Link 
          className='btn btn-outline-primary mx-2'
          to={`/editUser/${user.userId}`}
          >
            Edit</Link>
          <Link className='btn btn-danger mx-2'
          to={`/deleteUser/${user.userId}`}
          >
            Delete</Link>
        </td>
        </tr>
        ))
    }
    
  </tbody>
</table>
        </div>
    </div>
  )
}
