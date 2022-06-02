import {BrowserRouter as Router, Link, Route, Routes} from "react-router-dom";
import Reservation from "./Reservation";
import AboutUs from "./AboutUs";
import HowToOrder from "./HowToOrder";
import Menus from "./Menus";
import SaladsMenus from "./SaladsMenus";
import DesertsMenus from "./DesertsMenus";
import PastaMenus from "./PastaMenus";
import PizzaMenus from "./PizzaMenus";
import LogIn from "./LogIn";
import Cart from "./Cart";
import Register from "./Register";
import Details from "./Details";
import React from "react";
import Index from "./Index";
import Contacts from "./Contacts";
import logoImage from "./pictures/logo.png"
import Home from "./Home";
import ReservationsEmployee from "./EmployeePages/ReservationsEmployee";

const Navigation = (loggedUser) =>  {
    if(loggedUser.loggedUser == null) {
        return (
            <nav className="navBar">
                <div className="imageLogo">
                    <img src={logoImage} alt=""/>
                </div>
                <div className='navLinks'>
                    <Link to="/">Home</Link>
                </div>
                <div className="cartAndLog">
                    <Link to="/logIn">Log In</Link>
                </div>
            </nav>
        )
    }
else if(loggedUser.loggedUser.category == "CLIENT") {
    return (

        <nav className="navBar">
            <div className="imageLogo">
                <img src={logoImage} alt=""/>
            </div>
            <div className='navLinks'>
                <Link to="/">Home</Link>
                <Link to="/menus">Menu</Link>
                <Link to="/howToOrder">How to order</Link>
                <Link to="/reservation">Reservation</Link>
                <Link to="/contacts">Contacts</Link>
            </div>
            <div className="cartAndLog">
                <Link to="/logOut">Log Out</Link>
                <Link to="/cart">
                    <button className="cartButton">
                        Cart
                    </button>
                </Link>
            </div>
        </nav>
    )
}
else if(loggedUser.loggedUser.category == "WORKER") {
    return (
        <nav className="navBar">
            <div className="imageLogo">
                <img src={logoImage} alt=""/>
            </div>
            <div className='navLinks'>
                <Link to="/">Home</Link>
                <Link to="/menusEmployee">Meals</Link>
                <Link to="/ordersEmployee">Orders</Link>
                <Link to="/reservationsEmployee">Reservations</Link>
                <Link to="/sales">Sales</Link>
            </div>
            <div className="cartAndLog">
                <Link to="/logOut">Log Out</Link>
            </div>
        </nav>
    )
}
}
export default Navigation