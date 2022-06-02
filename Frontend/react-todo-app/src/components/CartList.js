import React, {useEffect, useState} from "react";
import axios from "axios";
import Cookies from "universal-cookie";

const CartList = (loggedUser) => {
    let decrease = "<";
    let increase = ">";
    const [orderedMeals, setOrderedMeals] = useState([]);
    let list = [];
    let cartItem;
    //axios.defaults.baseURL = "http://localhost:8080";

    const cookies = new Cookies();
    const token = cookies.get("accessToken");
    useEffect(() => {
        getOrderedMeals();
    }, [loggedUser.loggedUser])
    function getOrderedMeals() {
        const config = {
            headers: { Authorization: `Bearer ${token}` }
        };
        const bodyParams = {
            "user": loggedUser.loggedUser,
        };
        axios.get(
            `http://localhost:8080/cart/cartItems`,
            bodyParams,
            config
        )
            .then(function (response) {
                setOrderedMeals(response.data);
                console.log(orderedMeals)
            })
            .catch(function (error) {
                console.log(error);
            });
        /*const userId = loggedUser.loggedUser.username;
        var config = {
            method: "get",
            url: `http://localhost:8080/cart/specificCartItems/${1}`,
            headers: {
                "Authorization": `Bearer ${token}`,
            },
        };

        axios(config)
            .then(function (response) {
                setOrderedMeals(response.data);
            })
            .catch(function (error) {
                console.log(error);
            });*/
    }
    /*for(let i = 0; i < orderedMeals.length; i++)
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
    }*/
    return (
        <>
            <center>

            </center>
        </>
    )
}
export default CartList