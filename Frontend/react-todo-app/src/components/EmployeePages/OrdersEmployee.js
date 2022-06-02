import React, {useEffect, useState} from "react";
import axios from "axios";
import Cookies from "universal-cookie";
import {findAllByDisplayValue} from "@testing-library/react";
import button from "bootstrap/js/src/button";
import {useNavigate} from "react-router-dom";

const OrdersEmployee = (loggedUser) => {
    const [orders, setOrders] = useState([]);
    const [users, setUsers] = useState([]);
    const [usersLength, setUsersLength] = useState(0);
    const [someNumbers2, setSomeNumbers2] = useState(0);
    const [warning, setWarning] = useState("");
    const [usersChanger, setUsersChanger] = useState(0);
    const [addings, setAddings] = useState([]);
    const [newAddings, setNewAddings] = useState([]);
    const cookies = new Cookies();
    const token = cookies.get("accessToken");

    let navigate = useNavigate();

    function getAddings() {
        var config = {
            method: "get",
            url: `http://localhost:8080/orders/approvedAddings`,
            headers: {
                "Authorization": `Bearer ${token}`,
            },
        };

        axios(config)
            .then(function (response) {
                setAddings(response.data);
                console.log(response.data);
            })
            .catch(function (error) {
                console.log(error);
            });
    }

    const getOrders = async () => {
        var config = {
            method: "get",
            url: `http://localhost:8080/orders/all`,
            headers: {
                "Authorization": `Bearer ${token}`,
            },
        };

        await axios(config)
            .then(function (response) {
                setOrders(response.data);
                console.log(response.data);
            })
            .catch(function (error) {
                console.log(error);
            });
    }

    function getUserIds() {
        var config = {
            method: "get",
            url: `http://localhost:8080/orders/specificUsers`,
            headers: {
                "Authorization": `Bearer ${token}`,
            },
        };

        axios(config)
            .then(function (response) {
                setUsers(response.data);
                setUsersLength(response.data.length)
                console.log(response.data);
            })
            .catch(function (error) {
                console.log(error);
            });
    }
    function setOrderAsComplete(id) {
        var config = {
            method: "get",
            url: `http://localhost:8080/orders/setAsOrderComplete/${id}`,
            headers: {
                "Authorization": `Bearer ${token}`,
            },
        };

        axios(config)
            .then(function (response) {
                console.log(response.data);
                navigate(`/successfullyCompletedOrder`);
            })
            .catch(function (error) {
                console.log(error);
            });
    }

    useEffect(() => {
        getOrders();
        getAddings();
        getUserIds();
    }, [setSomeNumbers2])

    let ordersByUser = [];
    let addingsByOrder = [];

    let listOfElements = [];
    let listOfUserElements = [];
    for(let a = 0; a < users.length; a++) {
        let finalPrice = 3;
        ordersByUser = [];
        listOfElements = [];
        let cutlaries = (<></>);
        console.log("users.length");
        console.log(usersLength);
        console.log(users.length);
        console.log(users);
       // let numberOfItems = 0;
        for (let b = 0; b < orders.length; b++) {
            if (users.at(a).id == orders.at(b).user.id) {
                finalPrice += orders.at(b).meal.price * orders.at(b).numberOfItems;
                ordersByUser.push(orders.at(b))
            }
        }
        listOfElements.push(
            <><br/><br/>
                <div>
                    <p><b><i>User Address:</i></b> {users.at(a).address}</p>
                    <p><b><i>User Email:</i></b> {users.at(a).email}</p>
                    <p><b><i>User Phone:</i></b> {users.at(a).phone}</p>
                </div><br/>
            </>
        )
        for (let c = 0; c < ordersByUser.length; c++) {
            addingsByOrder = [];
            if(ordersByUser.at(c).cutlariesNeeded == "true") {
                cutlaries = (
                    <p>Cutlaries needed</p>
                )
            }
            else if(ordersByUser.at(c).cutlariesNeeded == "false") {
                cutlaries = (
                    <p>Cutlaries not needed</p>
                )
            }
            for(let d = 0; d < addings.length; d++) {
                if(addings.at(d).cartItem.id == ordersByUser.at(c).id) {
                    finalPrice += addings.at(d).adding.price * ordersByUser.at(c).numberOfItems;
                    addingsByOrder.push(
                        <>
                            {addings.at(d).adding.name}<br/>
                    </>
                    );
                }
            }
            console.log("addingsByOrder");
            console.log(addingsByOrder);
            listOfElements.push(
                <>
                    <div className="orderItem">
                        <div>
                            <img src={ordersByUser.at(c).meal.image} alt=""/>
                        </div>
                        <div>
                            <br/><br/>
                            <b><i>Name of Meal:</i></b><br/><br/>
                            {ordersByUser.at(c).meal.name}<br/><br/>
                        </div>
                        <div>
                            <br/><br/>
                            <b><i>Number of Items:</i></b><br/><br/>
                            {ordersByUser.at(c).numberOfItems}<br/><br/>
                        </div>
                        <div>
                            <br/><br/>
                            <b><i>Addings:</i></b><br/><br/>
                            {addingsByOrder}<br/><br/>
                        </div>
                    </div><br/>
                </>
            )
        }
        listOfElements.push(
            <>
                {cutlaries}<br/>
            </>
        )
        listOfElements.push(
            <>
                <b><i>Final Price:</i></b> {Math.round(finalPrice * 100)/100}$<br/><br/>
            </>
        )
        listOfElements.push(
            <>
            <button className="normalButton" onClick={() => {
                setOrderAsComplete(users.at(a).id)
            }}>
                Set Order As Complete
            </button><br/><br/>
            </>
        )
        listOfUserElements.push(
            <>
            <div className="userElement">
                {listOfElements}
            </div><br/><br/><br/><br/>
            </>
        )
    }

    return (
        <div className="mainBody">
            <center><br/><br/>
                <h1>View Orders</h1><br/>
                <p className="WarningMessage">{warning}</p>
                <br/><br/>
                {listOfUserElements}
                                        <br/><br/><br/><br/><br/><br/>
            </center>
        </div>
    )
}
export default OrdersEmployee