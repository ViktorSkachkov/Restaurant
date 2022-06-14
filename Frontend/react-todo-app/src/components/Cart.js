import React, {useEffect, useState} from "react";
import CartList from "./CartList";
import axios from "axios";
import logo from "./pictures/logo.png";
import Cookies from "universal-cookie";

const Cart = (loggedUser) => {
    const [someNumbers, setSomeNumbers] = useState(0);
    const [someNumbers2, setSomeNumbers2] = useState(0);
    const [warning, setWarning] = useState("");
    const [cartItems, setCartItems] = useState([]);
    const [addings, setAddings] = useState([]);
    const [listOfNumberOfItems, setListOfNumberOfItems] = useState([]);
    const [address, setAddress] = useState();
    const [cutlaries, setCutlaries] = useState("false");
    let finalPrice = 3;

    const cookies = new Cookies();
    const token = cookies.get("accessToken");

    useEffect(() => {
        fillListWithNumbers();
        getOrderedMeals();
        getAddings();
    }, [loggedUser.loggedUser])

    function orderFood() {
        let userId = 0;
        if(loggedUser.loggedUser != null) {
            userId = loggedUser.loggedUser.id;
        }
        var config = {
            method: "get",
            url: `http://localhost:8080/orders/addOrders/${userId}/${cutlaries}`,
            headers: {
                "Authorization": `Bearer ${token}`,
            },
        };

        axios(config)
            .then(function (response) {
                console.log(response.data);
                setSomeNumbers2(someNumbers2 + 1);
                setWarning("Order successfully made!");
            })
            .catch(function (error) {
                console.log(error);
            });
    }

    function deleteCartItem(id) {
        var config = {
            method: "get",
            url: `http://localhost:8080/cart/deleteCartItem/${id}`,
            headers: {
                "Authorization": `Bearer ${token}`,
            },
        };

        axios(config)
            .then(function (response) {
                console.log(response.data);
                setWarning("Cart item successfully deleted!");
                setSomeNumbers2(someNumbers2 + 1);
            })
            .catch(function (error) {
                console.log(error);
            });
    }


    useEffect(() => {
        getOrderedMeals();
        getAddings();
    }, [someNumbers2])



    function increaseNumber(id) {
        let newValue = listOfNumberOfItems.at(id) + 1;
        listOfNumberOfItems[id] = newValue;
        setSomeNumbers(someNumbers+1);
        finalPrice += cartItems.at(id).price;
        let cartId = cartItems.at(id).id;
        setWarning("");
        var config = {
            method: "get",
            url: `http://localhost:8080/cart/increase/${cartId}`,
            headers: {
                "Authorization": `Bearer ${token}`,
            },
        };

        axios(config)
            .then(function (response) {
                console.log(response.data);
            })
            .catch(function (error) {
                console.log(error);
            });
    }
    function decreaseNumber(id) {
        let newValue = listOfNumberOfItems.at(id) - 1;
        setSomeNumbers(someNumbers + 1);
        if(newValue > 0) {
            listOfNumberOfItems[id] = newValue;
            finalPrice -= cartItems.at(id).price;
            let cartId = cartItems.at(id).id;
            setWarning("");
            var config = {
                method: "get",
                url: `http://localhost:8080/cart/decrease/${cartId}`,
                headers: {
                    "Authorization": `Bearer ${token}`,
                },
            };

            axios(config)
                .then(function (response) {
                    console.log(response.data);
                })
                .catch(function (error) {
                    console.log(error);
                });
        }
        else {
            setWarning("The number of items needs to be more than 0!");
        }
    }
    useEffect(() => {
        getAddings();
    }, [someNumbers])



    useEffect(() => {
        initialAddress();
    }, [])


    function getAddings() {
        let userId = 0;
        if(loggedUser.loggedUser != null) {
            userId = loggedUser.loggedUser.id;
            console.log(userId);
        }
        var config = {
            method: "get",
            url: `http://localhost:8080/cart/specificAddings/${userId}`,
            headers: {
                "Authorization": `Bearer ${token}`,
            },
        };

        axios(config)
            .then(function (response) {
                setAddings(response.data);
                console.log("Addings");
                console.log(response.data);
            })
            .catch(function (error) {
                console.log(error);
            });
    }
function initialAddress() {
    if(loggedUser.loggedUser != null) {
        setAddress(loggedUser.loggedUser.address);
    }
}


    function getOrderedMeals() {
        let userId = 0;
        if(loggedUser.loggedUser != null) {
            userId = loggedUser.loggedUser.id;
        }
        var config = {
            method: "get",
            url: `http://localhost:8080/cart/specificCartItems/${userId}`,
            headers: {
                "Authorization": `Bearer ${token}`,
            },
        };

        axios(config)
            .then(function (response) {
                setCartItems(response.data);
            })
            .catch(function (error) {
                console.log(error);
            });
    }
    function fillListWithNumbers() {
        let userId = 0;
        if(loggedUser.loggedUser != null) {
            userId = loggedUser.loggedUser.id;
            console.log(userId);
        }
        var config = {
            method: "get",
            url: `http://localhost:8080/cart/listOfNumbers/${userId}`,
            headers: {
                "Authorization": `Bearer ${token}`,
            },
        };

        axios(config)
            .then(function (response) {
                setListOfNumberOfItems(response.data);
                console.log(response.data);
            })
            .catch(function (error) {
                console.log(error);
            });
    }
    function onChangeCutlaries() {
        if(cutlaries == "true") {
            setCutlaries("false");
        }
        else if(cutlaries == "false") {
            setCutlaries("true");
        }
    }
    let list = [];
    let addingElement;
    let addingElements = [];
    let cartItem;
    let decrease = "<";
    let increase = ">";
    console.log("cartItems");
    console.log(cartItems);
    //function fillWithCartItems() {
        for (let i = 0; i < cartItems.length; i++) {
            addingElements = [];
            //let price = (cartItems.at(i).meal.price * listOfNumberOfItems.at(i));
            let price = cartItems.at(i).meal.price;
            finalPrice += (cartItems.at(i).meal.price * listOfNumberOfItems.at(i));
            for (let u = 0; u < addings.length; u++) {
                if (addings.at(u).cartItem.id == cartItems.at(i).id) {
                    addingElement = (
                        <>{addings.at(u).adding.name}<br/></>
                    )
                    //price += (addings.at(u).adding.price * listOfNumberOfItems.at(i));
                    price += addings.at(u).adding.price;
                    finalPrice += (addings.at(u).adding.price * listOfNumberOfItems.at(i));
                    addingElements.push(addingElement);
                }

            }

            cartItem = (
                <>
                <div className="displayCartItems">
                    <div className="imageAndName">
                        <img src={cartItems.at(i).meal.image} height="60px" width="60px" alt=""/> <p className="cartTitle">{cartItems.at(i).meal.name}</p>
                    </div>
                    <div>
                        {addingElements}
                    </div>
                    <div className="rightSideOfCartItem">
                        <button className="cartButton" onClick={() => {
                            decreaseNumber(i)
                        }}>{decrease}</button>
                        <input type="text" className="changedSize" value={listOfNumberOfItems.at(i)}/>
                        <button className="rightArrowCartButton" onClick={() => {
                            increaseNumber(i)
                        }}>{increase}</button>
                        X{price}
                        <button className="deleteCartButton" onClick={() => {
                            deleteCartItem(cartItems.at(i).id)
                        }}>Delete</button>
                    </div>
                </div>
                    <br/>
                </>
            )
            list.push(cartItem)
        }

   // }
   // fillWithCartItems();
        return (
            <div className="mainBody">
                <center>
                    <br/>
                    <h1>CART</h1><br/>

                    {list}
                    <br/><br/>
                    <div className="cutlaryAndPrice">
                        <div className="cutlaries">
                            <div>
                                <input type="checkbox"  onClick={() => {
                                    onChangeCutlaries()
                                }}/> I need cutlaries
                            </div>
                        </div>
                        <div>
                            <div className="deliveryPrice">
                                Delivery: 3.00
                            </div>
                            <div className="displayFinalPrice">
                                Final price: {Math.round(finalPrice * 100)/100}$
                            </div>
                        </div>
                    </div>
                    <br/><br/><br/><br/><br/><br/><br/><br/>
                    <button className="normalButton" onClick={() => {
                        orderFood()
                    }}>Order</button>
                    <br/><br/><br/>
                    <p className="WarningMessage">{warning}</p>
                    <br/><br/><br/><br/><br/><br/><br/><br/><br/>
                </center>
            </div>
        )

}
export default Cart