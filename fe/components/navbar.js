import React from 'react'
import Logo from '../assets/lalagoLogo.png'
import './navbar.css'

function Navbar() {
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
        
      
        <button className="login-btn">Đăng nhập</button>
        <button className="register-btn">Đăng ký</button>
      </div>
    </div>
  )
}

export default Navbar
