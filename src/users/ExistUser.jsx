import axios from 'axios';
import React, { useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import '../css/ExistUser.css';


export default function ExistUser() {
  const navigate = useNavigate();

  const [user, setUser] = useState({
    username: '',
    password: '',
  });

  const { username, password } = user;

  const onInputChange = (e) => {
    const { name, value } = e.target;
    setUser((prevUser) => ({ ...prevUser, [name]: value }));
  };

  const onSubmit = async (e) => {
    e.preventDefault();
    try {
        
      if (!username || !password) {
        console.log('Please enter both username and password');
        alert("Please enter both username and password");
        return;
      }

      
      const response = await axios.post('http://localhost:8080/login', user);

      if (response.data==="Login success")
       {
        console.log('Login successful');
        alert("Login Success");
        navigate('/recipe');
      } 
      else 
      {
        console.log('Invalid username or password');
        alert('Invalid username or password');

      }
    } catch (error) {
      console.error('Login error:', error);
    }
  };

  

  return (
    <div className="style">
    <div className="styling container">
      <div className="row">
        <div className="col-md-6 offset-md-3 p-4 mt-2">
          <h1 className="text-center m-4 ">Login User</h1>
          <form onSubmit={onSubmit}>
            <div className="mb-4 fs-5">
              <label htmlFor="username" className="form-label">
                User Name
              </label>
              <input
                type="text"
                className="form-control"
                placeholder="Enter your Name"
                name="username"
                value={username}
                onChange={onInputChange}
              />
            </div>
            <div className="mb-4 fs-5">
              <label htmlFor="password" className="form-label">
                Password
              </label>
              <input
                type="password"
                className="form-control"
                placeholder="Enter your password"
                name="password"
                value={password}
                onChange={onInputChange}
              />
            </div>
            <button type="submit" className="btn btn-outline-primary fs-5">
              Log In
            </button>
            <Link className="btn btn-outline-danger m-2 fs-5" to="/">
              Cancel
            </Link>
            <h5 className='mt-3'>
            New to Receptoria?
            <Link to="/signup"> SignUp! </Link>
            </h5>
          </form>
        </div>
      </div>
    </div>
    </div>
  );
}