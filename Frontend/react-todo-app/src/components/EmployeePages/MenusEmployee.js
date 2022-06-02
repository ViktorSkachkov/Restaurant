import React, {useEffect, useState} from "react";
import {useNavigate} from "react-router-dom";
import MenusListEmployee from "./MenusListEmployee";
import axios from "axios";
import Cookies from "universal-cookie";
import logo from "./pictures/logo.png";

const MenusEmployee = (updateUser) => {
    let navigate = useNavigate();
    const [category, setCategory] = useState("All");

    const [meals, setMeals] = useState([]);
    const cookies = new Cookies();
    const token = cookies.get("accessToken");
    let pizzaList = [];
    let pastaList = [];
    let saladsList = [];
    let dessertsList = [];
    let finalCode;
    let reservationItem;
    function deleteMeal(id) {
        const token = cookies.get("accessToken");
        let paramName = meals.find(x => x.id == id).name;
        var config = {
            method: "get",
            url: `http://localhost:8080/orders/deleteMeal/${id}`,
            headers: {
                "Authorization": `Bearer ${token}`,
            },
        };

        axios(config)
            .then(function (response) {
                console.log(response.data);
                navigate(`/successfullyDeletedMeal/${paramName}`);
            })
            .catch(function (error) {
                console.log(error);
            });
    }
    useEffect(() => {
        getMeals();
    }, [updateUser.loggedUser])
    const getMeals = async () => {
        var config = {
            method: "get",
            url: `http://localhost:8080/orders/Meals`,
            headers: {
                "Authorization": `Bearer ${token}`,
            },
        };

        await axios(config)
            .then(function (response) {
                setMeals(response.data);
            })
            .catch(function (error) {
                console.log(error);
            });
    }
    const groupMeals = (e) => {
        e.preventDefault();
        if(category == "All") {
            getMeals();
        }
        else {
            var config = {
                method: "get",
                url: `http://localhost:8080/orders/${category}`,
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
        }
    }

    for (let i = 0; i < meals.length; i++) {
        if (meals.at(i).category.name == "Pizza") {
            reservationItem = (
                <div className="menuElement">
                    <div>
                        <img src={logo} width="200px" alt=""/>
                    </div>
                    <div className="ingredientsMiddle">
                        <p>{meals.at(i).name}<br/>
                            Ingredients: <br/>
                            {meals.at(i).description}</p>
                    </div>
                    <div>
                        <div>
                            <button className="viewMenusButton" onClick={() => {
                                navigate(`/updateMeal/${meals.at(i).id}`, {});
                            }}>
                                Update
                            </button>
                            <button className="viewMenusButton" onClick={() => deleteMeal(meals.at(i).id)}>
                                Delete
                            </button>
                        </div>
                    </div>
                </div>
            )
            pizzaList.push(reservationItem);
        }
        if (meals.at(i).category.name == "Pasta") {
            reservationItem = (
                <div className="menuElement">
                    <div>
                        <img src={logo} width="200px" alt=""/>
                    </div>
                    <div className="ingredientsMiddle">
                        <p>{meals.at(i).name}<br/>
                            Ingredients: <br/>
                            {meals.at(i).description}</p>
                    </div>
                    <div>
                        <div>
                            <button className="viewMenusButton" onClick={() => {
                                navigate(`/updateMeal/${meals.at(i).id}`, {});
                            }}>
                                Update
                            </button>
                            <button className="viewMenusButton" onClick={() => deleteMeal(meals.at(i).id)}>
                                Delete
                            </button>
                        </div>
                    </div>
                </div>
            )
            pastaList.push(reservationItem);
        }
        if (meals.at(i).category.name == "Salads") {
            reservationItem = (
                <div className="menuElement">
                    <div>
                        <img src={logo} width="200px" alt=""/>
                    </div>
                    <div className="ingredientsMiddle">
                        <p>{meals.at(i).name}<br/>
                            Ingredients: <br/>
                            {meals.at(i).description}</p>
                    </div>
                    <div>
                        <div>
                            <button className="viewMenusButton" onClick={() => {
                                navigate(`/updateMeal/${meals.at(i).id}`, {});
                            }}>
                                Update
                            </button>
                            <button className="viewMenusButton" onClick={() => deleteMeal(meals.at(i).id)}>
                                Delete
                            </button>
                        </div>
                    </div>
                </div>
            )
            saladsList.push(reservationItem);
        }
        if (meals.at(i).category.name == "Desserts") {
            reservationItem = (
                <div className="menuElement">
                    <div>
                        <img src={logo} width="200px" alt=""/>
                    </div>
                    <div className="ingredientsMiddle">
                        <p>{meals.at(i).name}<br/>
                            Ingredients: <br/>
                            {meals.at(i).description}</p>
                    </div>
                    <div>
                        <div>
                            <button className="viewMenusButton" onClick={() => {
                                navigate(`/updateMeal/${meals.at(i).id}`, {});
                            }}>
                                Update
                            </button>
                            <button className="viewMenusButton" onClick={() => deleteMeal(meals.at(i).id)}>
                                Delete
                            </button>
                        </div>
                    </div>
                </div>
            )
            dessertsList.push(reservationItem);
        }
    }
    const onChangeCategory = event => {
        setCategory(event.target.value);
    }

    finalCode = (
        <>
            <h3>Pizza</h3>
            {pizzaList}
            <h3>Pasta</h3>
            {pastaList}
            <h3>Salads</h3>
            {saladsList}
            <h3>Desserts</h3>
            {dessertsList}<br/><br/><br/>
        </>
    )

    return (
        <div className="mainBody">
            <center><br/><br/>
                <h1>View</h1><br/>
                <button className="normalButton" onClick={() => {
                    navigate(`/addMeal`, {});
                }}>Add New Meal
                </button>
                <br/><br/>
                <form onSubmit={groupMeals}>
                    <label htmlFor="username">Search Engine</label><br/><br/>
                    <select
                        className="Label"
                        onChange={onChangeCategory}
                    >
                        <option value={"All"}>All</option>
                        <option value={"Pizza"}>Pizza</option>
                        <option value={"Pasta"}>Pasta</option>
                        <option value={"Salads"}>Salads</option>
                        <option value={"Desserts"}>Desserts</option>
                    </select> <button type="submit" className="searchButton">Search By Category</button>
                </form>
                <br/><br/>
                {finalCode}
            </center>
            <br/><br/><br/>
        </div>
    )
}
export default MenusEmployee;