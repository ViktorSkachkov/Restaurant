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
                    <Link to="/logIn"><p className="testNullLogIn">Log In</p></Link>
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
                <Link to="/"><p className="testEmployeeHome">Home</p></Link>
                <Link to="/menus"><p className="testEmployeeMenus">Menu</p></Link>
                <Link to="/howToOrder"><p className="testEmployeeHowToOrder">How to order</p></Link>
                <Link to="/reservation"><p className="testEmployeeReservation">Reservation</p></Link>
            </div>
            <div className="cartAndLog">
                <Link to="/logOut"><p className="testEmployeeLogOut">Log Out</p></Link>
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
                <Link to="/"><p className="testWorkerHome">Home</p></Link>
                <Link to="/menusEmployee"><p className="testWorkerMeals">Meals</p></Link>
                <Link to="/ordersEmployee"><p className="testWorkerOrders">Orders</p></Link>
                <Link to="/reservationsEmployee"><p className="testWorkerReservations">Reservations</p></Link>
            </div>
            <div className="cartAndLog">
                <Link to="/logOut"><p className="testWorkerLogOut">Log Out</p></Link>
            </div>
        </nav>
    )
}
}
export default Navigation