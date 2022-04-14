import React, {useState} from "react";
import {Link, NavLink, BrowserRouter as Router, Routes, Route} from "react-router-dom";
import Footer from "./Footer";
import InfoForPizzaMeal from "./InfoForPizzaMeal";
import HowToOrder from "./HowToOrder";
import AboutUs from "./AboutUs";
import Reservation from "./Reservation";
import LogIn from "./LogIn";
import Register from "./Register";
import Menus from "./Menus";
import PastaMenus from "./PastaMenus";
import PizzaMenus from "./PizzaMenus";
import SaladsMenus from "./SaladsMenus";
import DesertsMenus from "./DesertsMenus";
import Details from "./Details";


function Index() {
    return (
            <Router>
            <nav className="navBar">
                <div className="imageLogo">
                    <img src="" alt=""/>
                </div>
                <div className='navLinks'>
                    <Link to="/">Home</Link>
                    <Link to="/menus">Menu</Link>
                    <Link to="/howToOrder">How to order</Link>
                    <Link to="/reservation">Reservation</Link>
                    <Link to="/aboutUs">About us</Link>
                </div>
                <div className="cartAndLog">
                    <Link to="/logIn">Log In</Link>
                    <button><a href="" className="cartButton">Cart</a></button>
                </div>
            </nav>
            <Routes>
                <Route path="/reservation" element={<Reservation/>}/>
                <Route path="/aboutUs" element={<AboutUs/>}/>
                <Route path="/howToOrder" element={<HowToOrder/>}/>
                <Route path="/menus" element={<Menus/>}/>
                <Route path="/saladsMenus" element={<SaladsMenus/>}/>
                <Route path="/desertsMenus" element={<DesertsMenus/>}/>
                <Route path="/pastaMenus" element={<PastaMenus/>}/>
                <Route path="/pizzaMenus" element={<PizzaMenus/>}/>
                <Route path="/logIn" element={<LogIn/>}/>
                <Route path="/register" element={<Register/>}/>
                <Route path="/details/:id" element={<Details/>}/>
            </Routes>

                <div className="footerLine">
                    <p>
                        @Pizzeria Selinia All Rights reserved
                    </p>
                </div>
            </Router>
    )
}

export default Index