import React, {useState} from "react";
import {Link, NavLink, BrowserRouter as Router, Routes, Route} from "react-router-dom";
import Footer from "./Footer";
import InfoForPizzaMeal from "./InfoForPizzaMeal";


const Navbar = () => {
    return (
        /*<nav>
            <div className="navBar">
                <div className="imageLogo">
            <img src="" alt=""/>
                </div>
                <div className='navLinks'>
            <a href="Index.js">Home</a>
            <a href="PastaMenus.js">Menu</a>
            <a href="">How to order</a>
            <a href="">Reservation</a>
            <a href="">About us</a>
                </div>
                <div className="cartAndLog">
                    <a href="">Log In</a>
                    <button><a href="" className="cartButton">Cart</a></button>
                </div>
            </div>
        </nav>*/
        <>
                <nav className="navBar">
                    <div className="imageLogo">
                        <img src="" alt=""/>
                    </div>
                    <div className='navLinks'>
                        <Link to="/">Home</Link>
                        <Link to="/">Menu</Link>
                        <Link to="/">How to order</Link>
                        <Link to="/info">Reservation</Link>
                        <Link to="/footer">About us</Link>
                    </div>
                    <div className="cartAndLog">
                        <a href="">Log In</a>
                        <button><a href="" className="cartButton">Cart</a></button>
                    </div>
                </nav>
                <Routes>
                    <Route path="/footer" element={<Footer/>}/>
                    <Route path="/info" element={<InfoForPizzaMeal/>}/>
                </Routes>
        </>
    )
}
export default Navbar