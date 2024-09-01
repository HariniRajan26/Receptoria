import React from 'react'
import '../css/Background.css';
import backgroundImage from '../Components/background.jpg';
import { Link } from 'react-router-dom';


export default function Main() {
    const divStyle = {
        backgroundImage: `url(${backgroundImage})`,
        backgroundSize: 'cover',
        height: '100vh', 
      };
    
      return (
        <div style={divStyle} className='BackGround'>
            <div className="content-wrapper">
            <h1 >Receptoria</h1>
            <Link to={"/login"}>Let's😋Taste</Link>
            </div>
        </div>
      );
}
