import React, {useEffect, useState} from "react";
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
import axios from "axios";
import Cookies from "universal-cookie";

const Home = (props) => {
    let navigate = useNavigate();
    const [user, setUser] = useState(props.loggedUser);
    const [categories, setCategories] = useState([]);

    const cookies = new Cookies();
    const token = cookies.get("accessToken");
    useEffect(() => {
        setUser(props.loggedUser);
        getUser();
    }, [props.loggedUser]);

    async function getUser() {
        setUser(props.loggedUser);
    };

    useEffect(() => {
        getCategories();
    }, [props.loggedUser])

    function getCategories() {
        var config = {
            method: "get",
            url: `http://localhost:8080/orders/Categories`,
            headers: {
                "Authorization": `Bearer ${token}`,
            },
        };

        axios(config)
            .then(function (response) {
                setCategories(response.data);
            })
            .catch(function (error) {
                console.log(error);
            });
    }

        let code = [];
        let component;
        let part;
    if(props.loggedUser != null) {
        if (props.loggedUser.category == "CLIENT") {
            for (let i = 0; i < categories.length; i++) {
                switch (categories.at(i).name) {
                    case "Pizza":
                        part = (<button className="categoryItemButton" key={categories.at(i).id} onClick={() => {
                            navigate("/pizzaMenus")
                        }}>VIEW MORE</button>);
                        break;
                    case "Pasta":
                        part = (<button className="categoryItemButton" key={categories.at(i).id} onClick={() => {
                            navigate("/pastaMenus")
                        }}>VIEW MORE</button>);
                        break;
                    case "Salads":
                        part = (<button className="categoryItemButton" key={categories.at(i).id} onClick={() => {
                            navigate("/saladsMenus")
                        }}>VIEW MORE</button>);
                        break;
                    case "Desserts":
                        part = (<button className="categoryItemButton" key={categories.at(i).id} onClick={() => {
                            navigate("/dessertsMenus")
                        }}>VIEW MORE</button>);
                        break;
                }
                component = (
                    <>
                        <div className="menuItem" key={categories.at(i).id}>
                            <img src={categories.at(i).image} alt=""/>
                            <br/>
                            <h3>{categories.at(i).name}</h3>
                            <br/>
                            <div className="menuButtons">
                                {part}
                            </div>
                        </div>
                    </>
                )
                code.push(component);
            }
        }
    }
        return (
            <div className="mainBody">
                <center>
                    <img src={pizzaImage} className="homeImage"/><br/><br/>
                    <h2>ABOUT US</h2><br/>
                    <div className="aboutUs">
                        <div className="Main_Page_Image_Container">
                            <img src={pizzaImage2} alt=""/>
                        </div>
                        <div className="Main_Page_Text_Container">
                            <p>We are Pizzeria Red Hot Pizza and we have dominated
                                the market in the Netherlands ever since we first opened in 1996.<br/><br/> We make
                                pizza, pasta and other meals of undisputed quality which wins the trust of our clients
                                and makes sure that they return to us every time for more.</p>
                        </div>
                    </div>
                    <br/>
                    <div className="menuList">
                        {code}
                    </div>
                </center>
                <br/><br/>
            </div>
        )
}

export default Home