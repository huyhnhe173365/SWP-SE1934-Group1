import React from 'react'
import Logo from '../assets/lalagoLogo.png'
import { useNavigate } from 'react-router-dom'
import './navbar.css'

function Navbar() {
  const navigate = useNavigate(); 

  const handleLogin = () => {
    navigate('/login'); 
  };

  const handleRegister = () => {
    navigate('/register'); 
  };
  return (
    <div className='navbar'>
      <div className='leftside'>
        <img src={Logo} alt="Lalago Logo" />
        <a href="#">Giao Hàng</a>
        <a href="#">Di Chuyển</a>
        <a href="#">Tài Xế</a>
        <a href="#">Ưu Đãi</a>
        <a href="#">Về Lalago</a>
      </div>
      <div className='rightside'>
        
        
        <button className="login-btn" onClick={handleLogin}>Đăng nhập</button>
        <button className="register-btn" onClick={handleRegister}>Đăng ký</button>
      </div>
    </div>
  )
}

export default Navbar
