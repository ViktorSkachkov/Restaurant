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

function Navigation() {
    return (
        <Router>
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
                    <Link to="/logIn">Log In</Link>
                    <Link to="/cart">
                        <button className="cartButton">
                            Cart
                        </button>
                    </Link>
                </div>
            </nav>

            <Routes>
                <Route path="/" element={<Index/>}/>
                <Route path="/contacts" element={<Contacts/>}/>
                <Route path="/reservation" element={<Reservation/>}/>
                <Route path="/aboutUs" element={<AboutUs/>}/>
                <Route path="/howToOrder" element={<HowToOrder/>}/>
                <Route path="/menus" element={<Menus/>}/>
                <Route path="/saladsMenus" element={<SaladsMenus/>}/>
                <Route path="/desertsMenus" element={<DesertsMenus/>}/>
                <Route path="/pastaMenus" element={<PastaMenus/>}/>
                <Route path="/pizzaMenus" element={<PizzaMenus/>}/>
                <Route path="/logIn" element={<LogIn/>}/>
                <Route path="/cart" element={<Cart/>}/>
                <Route path="/register" element={<Register/>}/>
                <Route path="/details/:id" element={<Details/>}/>
            </Routes>
        </Router>
    )
}
export default Navigation