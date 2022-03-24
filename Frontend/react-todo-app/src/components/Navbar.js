import React, {useState} from "react";
import {Link, NavLink} from "react-router-dom";


const Navbar = () => {
    return (
        <nav>
            <div className="navBar">
                <div className="imageLogo">
            <img src="" alt=""/>
                </div>
                <div className='navLinks'>
            <a href="Index.js">Home</a>
            <a href="PizzaMenus.js">Menu</a>
            <a href="">How to order</a>
            <a href="">Reservation</a>
            <a href="">About us</a>
                </div>
                <div className="cartAndLog">
                    <a href="">Log In</a>
                    <button><a href="" className="cartButton">Cart</a></button>
                </div>
            </div>
        </nav>
    )
}
export default Navbar