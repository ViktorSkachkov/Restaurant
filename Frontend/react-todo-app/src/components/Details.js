import React, {useEffect, useState} from "react";
import PastaMenuList from "./PastaMenuList";
import axios from "axios";
import {useNavigate, useParams} from "react-router-dom";

const Details = (props) => {
    let navigate = useNavigate();
    const [meal, setMeal] = useState();
    const [addings, setAddings] = useState([]);
    let params = useParams();
    axios.defaults.baseURL = "http://localhost:8080";
   /* function getMeal() {
        axios.get(`/individualTrack/?id=${id}`)
            .then(res => {setMeal(res.data)})
    }*/
    function getMeal() {
        console.log(params.id)
        axios.get(`/orders/${params.id}`)
            .then(res => {setMeal(res.data)})
    }
    function getAdding() {
        console.log(params.id)
        axios.get(`/orders/Addings`)
            .then(res => {setAddings(res.data)})
    }
    useEffect(() => {
        getMeal();
        getAdding();
    })
    let decrease = "<";
    let increase = ">";
    let component;
    let code = [];
    for(let i = 0; i < addings.length; i++) {
        component = (
            <div>
                <input type="text" checked="checked"/> - {addings.at(i).weight} g - {addings.at(i).price}€
            </div>
        )
        code.push(component);
    }
    code.pu
    if(meal != null) {
        return (
            <>
                <br/>
                <div className="backLine">
                    <button onClick={() => {
                        navigate("/menus");
                    }}>Go Back
                    </button>
                </div>
                <h2 className="menuTitle">{meal.name}</h2><br/>
              <center>
                  <div className="allDetails">
                      <div>
                          <img src="" alt=""/>
                      </div>
                      <div>
                      <p>{meal.description}</p>
                <h4 className="alergensTitle">Alergens</h4>
                          <div className="additionsBox">
                              <h4>Additions</h4>
                              <div className="additionsItems">
                                  {code}
                              </div>
                          </div>
                </div>
              </div>
                  <div className="quantityAndPrice">
                      <div className="priceDetails"><p>Final price:</p> <p className="displayPrice">{meal.price}€</p></div>
                      <div><button className="arrowButton">{decrease}</button> <input type="text" className="mealQuantity"/> <button className="arrowButton">{increase}</button></div>
                  </div>
              </center>
            </>
        )
    }
    else {
        return (
            <>
                No
            </>
        )
    }
}
export default Details