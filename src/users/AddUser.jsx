import axios from 'axios';
import React, { useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import '../css/ExistUser.css';

export default function AddUser() {

    let navigate=useNavigate()

    const [user,setUser]=useState({
        userId:"",
        username:"",
        password:""
    })

    const {userId, username, password}=user

    const onInputChange=(e)=>{

        setUser({...user, [e.target.name]:e.target.value})
    }

    const onSubmit=async (e) => {
        e.preventDefault();
        await axios.post("http://localhost:8080/addUserLogin", user);
        navigate("/");
    }
    

  return (
    <div className='style'>
    <div className='styling container'>
        <div className="row">
            <div className='col-md-6 offset-md-3'>
                <h2 className='text-center m-3 fs-1'>SignUp</h2>
                <form onSubmit={(e)=>onSubmit(e)}>
                <div className='mb-3 fs-5'>
                    <label htmlFor='Id' className='form-label'>
                        User Id
                    </label>
                    <input
                    type={"number"} 
                    className='form-control'
                    placeholder='Enter your Id'
                    name='userId'
                    value={userId}
                    onChange={(e)=>onInputChange(e)}
                    />
                </div>
                <div className='mb-3 fs-5'>
                    <label htmlFor='Name' className='form-label'>
                        User Name
                    </label>
                    <input
                    type={"text"} 
                    className='form-control'
                    placeholder='Enter your Name'
                    name='username'
                    value={username}
                    onChange={(e)=>onInputChange(e)}
                    />
                </div>
                <div className='mb-3 fs-5'>
                    <label htmlFor='Password' className='form-label'>
                        Password
                    </label>
                    <input
                    type={'password'} 
                    className='form-control'
                    placeholder='Enter your password'
                    name='password'
                    value={password}
                    onChange={(e)=>onInputChange(e)}
                    />
                </div>
                <button type='submit' className='btn btn-outline-primary fs-5'>Submit</button>
                <Link className='btn btn-outline-danger m-2 fs-5' to={"/"}>Cancel</Link>
                </form>
                <h5 className='mt-3 mb-4'>
           Already have an account? 
            <Link to="/login"> LogIn! </Link>
            </h5>
            </div>
        </div>
    </div>
    </div>
  )
}
