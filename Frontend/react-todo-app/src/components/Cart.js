import React, {useEffect, useState} from "react";
import CartList from "./CartList";
import axios from "axios";

function Cart() {
    const [orderedMeals, setOrderedMeals] = useState([]);
    let finalPrice = 0;
    let list = [];
    axios.defaults.baseURL = "http://localhost:8080";

    useEffect(() => {
        getOrderedMeals();
    })
    function getOrderedMeals() {
        axios.get('cart/orderedMeals').then(res => {setOrderedMeals(res.data)})
    }
    for(let i = 0; i < orderedMeals.length; i++)
    {
        finalPrice += orderedMeals.at(i).meal.price;
        list = orderedMeals.at(i).meal.addingList;
        if(list != null) {
            for (let u = 0; u < list.length; u++) {
                finalPrice += list.at(u).price;
            }
        }
    }
    return (
        <>
            <center>
        <br/>
        <h1>CART</h1><br/>
                <CartList/><br/><br/>
            <div className="cutlaryAndPrice">
                <div className="cutlaries">
                    <div>
                    <input type="checkbox"/> I need cutlaries
                    </div>
                </div>
                <div>
                <div className="deliveryPrice">
                    Delivery: 3.00
                </div>
                <div className="displayFinalPrice">
                    Final price: {finalPrice}
                </div>
                </div>
            </div><br/><br/><br/><br/><br/><br/>
                Address
                <input type="text" className="addressTextField" value="Address"/>
                <button className="changeButton">Change</button><br/><br/><br/>
            <button className="normalButton">Order</button><br/><br/><br/><br/><br/><br/><br/><br/><br/>
            </center>
        </>
    )
}
export default Cart