import React, {useState} from "react";
import {Link, NavLink, BrowserRouter as Router, Routes, Route, useNavigate} from "react-router-dom";
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
import Cart from "./Cart";
import pizzaImage from "./pictures/Pizza.jpg"
import pizzaImage2 from "./pictures/People_Eating_Pizza.jpg"

function Index() {
    return (
        <div>
            <center>
        <img src={pizzaImage} className="homeImage"/><br/><br/>
            <h2>ABOUT US</h2><br/>
                <div className="aboutUs">
                    <div className="Main_Page_Image_Container">
                    <img src={pizzaImage2} alt=""/>
                </div>
                    <div className="Main_Page_Text_Container">
                        <p>We are Pizzeria Red Hot Pizza and we have dominated
                            the market in the Netherlands ever since we first opened in 1996.<br/><br/>  We make pizza, pasta and other meals of undisputed quality which wins the trust of our clients and makes sure that they return to us every time for more.</p>
                    </div>
                </div>
            </center>
            <br/><br/>
        </div>
    )
}

export default Index