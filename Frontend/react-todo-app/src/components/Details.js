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
    let code;
    let list = [];
    for(let i = 0; i < addings.length; i++) {
        component = (
            <div>
                <input type="checkbox"/>  {addings.at(i).name} - {addings.at(i).weight} g - {addings.at(i).price}€
            </div>
        )
        list.push(component);
    }
    code = (
        <div className="additionsBox">
            {list}
        </div>
    );
    //code.push
    if(meal != null) {
        return (
            <>
                <br/>
                <center>
                <div className="backLine">
                    <button onClick={() => {
                        navigate("/menus");
                    }}>Go Back
                    </button>
                </div>
                <h2 className="menuTitle">{meal.name.toUpperCase()}</h2><br/>
                  <div className="allDetails">
                      <div>
                          <img src="" alt=""/>
                      </div>
                      <div>
                      <p>{meal.description}</p><br/><br/>
                <h2 className="alergensTitle">ALERGENS</h2><br/><br/>
                          <h2>ADDITIONS</h2><br/><br/>
                          <div className="additionsBox">
                              {code}
                          </div>
                </div>
              </div><br/><br/><br/>
                  <div className="quantityAndPrice">
                      <div className="priceDetails"><p>Final price:</p> <p className="displayPrice">{meal.price}€</p></div>
                      <div><button className="arrowButton">{decrease}</button> <input type="text" className="mealQuantity"/> <button className="arrowButton">{increase}</button></div>
                  </div><br/>
              </center><br/><br/><br/><br/><br/><br/><br/>
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