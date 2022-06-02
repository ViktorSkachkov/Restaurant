import React, {useEffect, useState} from "react";
import axios from "axios";
import {useNavigate} from "react-router-dom";
import Cookies from "universal-cookie";
import jwtDecode from "jwt-decode";

const CategoryList = (loggedUser) => {
    let navigate = useNavigate();
    const [categories, setCategories] = useState([]);

    const cookies = new Cookies();
    const token = cookies.get("accessToken");

    useEffect(() => {
        getCategories();
    }, [loggedUser.loggedUser])
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
    for(let i = 0; i < categories.length; i++) {
        switch (categories.at(i).name) {
            case "Pizza":
                part =( <button className="categoryItemButton" key={categories.at(i).id} onClick={() => {
                    navigate("/pizzaMenus")
                }}>VIEW MORE ></button>);
            break;
            case "Pasta":
                part =( <button className="categoryItemButton" key={categories.at(i).id} onClick={() => {
                    navigate("/pastaMenus")
                }}>VIEW MORE ></button>);
                break;
            case "Salads":
                part =( <button className="categoryItemButton" key={categories.at(i).id} onClick={() => {
                    navigate("/saladsMenus")
                }}>VIEW MORE ></button>);
                break;
            case "Desserts":
                part = ( <button className="categoryItemButton" key={categories.at(i).id} onClick={() => {
                    navigate("/dessertsMenus")
                }}>VIEW MORE ></button>);
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
    return (
        <>
            {code}
        </>
    )
}

export default CategoryList