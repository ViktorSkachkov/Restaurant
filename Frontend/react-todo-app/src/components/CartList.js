import React, {useEffect, useState} from "react";
import axios from "axios";

function CartList() {
    let decrease = "<";
    let increase = ">";
    const [orderedMeals, setOrderedMeals] = useState([]);
    let list = [];
    let cartItem;
    axios.defaults.baseURL = "http://localhost:8080";

    useEffect(() => {
        getOrderedMeals();
    })
    function getOrderedMeals() {
        axios.get('cart/orderedMeals').then(res => {setOrderedMeals(res.data)})
    }
    for(let i = 0; i < orderedMeals.length; i++)
    {
        cartItem = (
            <div className="displayCartItems">
                <div className="imageAndName">
                    <img src="" alt=""/>
                    <p>{orderedMeals.at(i).meal.name}</p>
                </div>
                <div className="rightSideOfCartItem">
                        <button className="cartButton">{decrease}</button>
                        <input type="text" className="changedSize" value={1}/>
                        <button className="rightArrowCartButton">{increase}</button>
                    X{orderedMeals.at(i).meal.price}
                    <button className="deleteCartButton">Delete</button>
                </div>
            </div>
        )
        list.push(cartItem)
    }
    return (
        <>
            <center>
                {list}
            </center>
        </>
    )
}
export default CartList