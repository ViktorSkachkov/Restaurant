import React, {useEffect, useState} from "react"
import axios from "axios";
import {useNavigate} from "react-router-dom";

function PizzaMenuList() {
    let navigate = useNavigate();
    const [meals, setMeals] = useState([]);

    axios.defaults.baseURL = "http://localhost:8080";
    useEffect(() => {
        getMeals();
    })
    function getMeals() {
        const getMeals = [];
        axios.get('/orders/Pizza').then(res => {setMeals(res.data)})
    }
    let code = [];
    let component;
    for(let i = 0; i < meals.length; i++) {
        component = (

            <div className="menuItem">
                <img src={meals.at(i).image} alt=""/>
                <br/>
                <h3>{meals.at(i).name}</h3>
                <br/>
                <p>{meals.at(i).description}</p>
                <br/>
                <div className="weightAndPrice">
                    <p>
                        {meals.at(i).weight}
                    </p>
                    <p>
                        {meals.at(i).price} €
                    </p>
                </div>
                <br/>
                <br/>
                <div className="menuButtons">
                    <button key={meals.at(i).id}  onClick={() => {
                        navigate(`/details/${meals.at(i).id}`, {

                        });
                    }}>Details ></button>
                    <button key={meals.at(i).id}><a href="">Add to cart ></a></button>
                </div>
            </div>
        )
        code.push(component);
    }
    return (
        <>
            {code}
        </>
    )

}



export default PizzaMenuList