import React, {useEffect, useState} from "react"
import axios from "axios";
import {useNavigate} from "react-router-dom";
import Cookies from "universal-cookie";

const PizzaMenuList = (loggedUser) => {
    let navigate = useNavigate();
    const [meals, setMeals] = useState([]);
    const cookies = new Cookies();
    const token = cookies.get("accessToken");
    //axios.defaults.baseURL = "http://localhost:8080";
    useEffect(() => {
        getMeals();
    }, [loggedUser.loggedUser])
    function getMeals() {
        //const getMeals = [];
        var config = {
            method: "get",
            url: `http://localhost:8080/orders/Pizza`,
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
    let code = [];
    let component;
    for(let i = 0; i < meals.length; i++) {
        component = (

            <div className="menuItem">
                <h3>{meals.at(i).name}</h3>
                <br/>
                <img src={meals.at(i).image} height="150px" width="150px" alt=""/>
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
                <div>
                    <button key={meals.at(i).id}  className="detailsButton" onClick={() => {
                        navigate(`/details${meals.at(i).id}`, {

                        });
                    }}>Details ></button>
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