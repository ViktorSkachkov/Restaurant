import axios from "axios";
import React, {useEffect, useState} from "react";
import Cookies from "universal-cookie";
import {useNavigate} from "react-router-dom";
import logo from "./pictures/logo.png";

const MenusListEmployee = (loggedUser) => {
    const [meals, setMeals] = useState([]);
    let navigate = useNavigate();
    const cookies = new Cookies();
    let list = [];
    let reservationItem;
    const token = cookies.get("accessToken");
    function deleteMeal(id) {
        var config = {
            method: "delete",
            url: `http://localhost:8080/orders/deleteMeal/${id}`,
            headers: {
                "Authorization": `Bearer ${token}`,
            },
        };

        axios(config)
            .then(function (response) {
                //setMessage(response.data);
            })
            .catch(function (error) {
                console.log(error);
            });
    }
    useEffect(() => {
        getMeals();
    })
    function getMeals() {
        //const getMeals = [];
        var config = {
            method: "get",
            url: `http://localhost:8080/orders/Meals`,
            headers: {
                "Authorization": `Bearer ${token}`,
            },
        };

        axios(config)
            .then(function (response) {
                setMeals(response.data);
            })
            .catch(function (error) {
                console.log(error);
            });
        //axios.get('/orders/Pizza').then(res => {setMeals(res.data)})
    }

    for(let i = 0; i < meals.length; i++) {
        reservationItem = (
            <div className="menuElement">
                <div>
                    <img src={logo} width="200px" alt=""/>
                </div>
                <div className="ingredientsMiddle">
<p>{meals.at(i).name} {meals.at(i).id}<br/>
    Ingredients: <br/>
                        {meals.at(i).description}</p>
                </div>
                <div>
                    <div>
                        <button className="viewMenusButton" onClick={() => {
                            navigate(`/updateMeal/${meals.at(i).id}`, {

                            });
                        }}>
                            Update
                        </button>
                        <button className="viewMenusButton" onClick={() => deleteMeal(meals.at(i).id) }>
                            Delete
                        </button>
                    </div>
                </div>
            </div>
        )
        list.push(reservationItem);
    }
    return (
        <>
            {list}
        </>
    )
}
export default MenusListEmployee;