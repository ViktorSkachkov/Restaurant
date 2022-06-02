import React, {useEffect, useState} from "react";
import PastaMenuList from "./PastaMenuList";
import axios from "axios";
import {useNavigate, useParams} from "react-router-dom";
import Cookies from "universal-cookie";

const Details = (loggedUser) => {
    let contextTypes = {
        router: () => true,
    }


    let navigate = useNavigate();
    const [meal, setMeal] = useState();
    const [addings, setAddings] = useState([]);
    const [addingsCheck, setAddingsCheck] = useState([]);
    const [numberOfItems, setNumberOfItems] = useState(1)
    const [warning, setWarning] = useState("")
    const [randomItem, setRandomItem] = useState(0)
    //const [price, setPrice] = useState(0)
    let params = useParams();

    const cookies = new Cookies();
    const token = cookies.get("accessToken");
    function getMeal() {
        var config = {
            method: "get",
            url: `http://localhost:8080/orders/${params.id}`,
            headers: {
                "Authorization": `Bearer ${token}`,
            },
        };

        axios(config)
            .then(function (response) {
                setMeal(response.data);
            })
            .catch(function (error) {
                console.log(error);
            });
    }
    function getAdding() {
        var config = {
            method: "get",
            url: `http://localhost:8080/orders/Addings`,
            headers: {
                "Authorization": `Bearer ${token}`,
            },
        };

        axios(config)
            .then(function (response) {
                setAddings(response.data);
            })
            .catch(function (error) {
                console.log(error);
            });
    }


    /*function displayPrice() {
        let finalPrice = 0;
        if(meal != null) {

                finalPrice += meal.price * numberOfItems;

            for(let i = 0; i < addings.length; i++) {
                if(addingsCheck.includes(addings.at(i).id)) {
                    finalPrice += addings.at(i).price;
                }
            }
            setPrice(finalPrice);
        }
    }*/


    useEffect(() => {
        getMeal();
        getAdding();
        //displayPrice();
    }, [loggedUser.loggedUser])




    function increaseNumber() {
        let newValue = numberOfItems + 1;
        if(newValue > 0) {
            setWarning("");
        }
        setNumberOfItems(newValue);
        let newItem = randomItem + 1;
        setRandomItem(newItem);
    }
    function decreaseNumber() {
        let newValue = numberOfItems - 1;
        if(newValue > 0) {
            setWarning("");
            setNumberOfItems(newValue);
        }
        else if(newValue <= 0) {
            setWarning("Value should be more than 0!");
        }
        let newItem = randomItem + 1;
        setRandomItem(newItem);
    }
    let decrease = "<";
    let increase = ">";
    let component;
    let code;
    let list = [];

    const onChangeAdding = event => {
        if(addingsCheck.includes(event.target.value)) {
            var index = addingsCheck.indexOf(event.target.value);
            if (index !== -1) {
                addingsCheck.splice(index, 1);
            }
        }
        else if(!addingsCheck.includes(event.target.value)) {
            addingsCheck.push(event.target.value);
        }
        let newItem = randomItem + 1;
        setRandomItem(newItem);
        console.log("addingsCheck");
        console.log(addingsCheck);
    }






    /*function displayInitialPrice() {
        let finalPrice = 0;
        if(meal != null) {
            finalPrice = meal.price;
            setPrice(finalPrice);
        }
    }
    useEffect(() => {
        displayInitialPrice();
    }, [randomItem])*/







    const addToCart = (e) => {
        e.preventDefault();
        const config = {
            headers: { Authorization: `Bearer ${token}` }
        };
        const bodyParams = {
            "numberOfItems": numberOfItems,
            "meal": meal,
            "user": loggedUser.loggedUser,
            "addings": addingsCheck
        };
        axios.post(
            `http://localhost:8080/orders/addToCart`,
            bodyParams,
            config
        )
            .then(function (response) {
                navigate(`/successfullyAddedCartItem/${meal.name}/${numberOfItems}/${params.id}`);
            })
            .catch(function (error) {
                console.log(error);
            });
    }




    let checkList = [];
    for(let i =0; i < addingsCheck.length; i++) {
        checkList = (<><p>{addingsCheck.at(i)}</p><br/></>)
    }

    for(let i = 0; i < addings.length; i++) {
        component = (
            <div>
                <input type="checkbox" value={addings.at(i).id} onChange={onChangeAdding}/>  {addings.at(i).name} - {addings.at(i).weight} g - {addings.at(i).price}€
            </div>
        )
        list.push(component);
    }
    code = (
        <div className="additionsBox">
            {list}
        </div>
    );
    if(meal != null) {
        let backButton;
        let finalPrice;
        let price = 0;
        price += meal.price;
        price *= numberOfItems;
        for(let i = 0; i < addings.length; i++) {
            if(addingsCheck.includes(addings.at(i).id.toString())) {
                price += addings.at(i).price * numberOfItems;
            }
        }
        finalPrice = (           <div className="priceDetails"><p>Final price:</p> <p className="displayPrice">{price}€</p></div>);
        if(meal.category.name == "Desserts") {
            backButton = (
                <div className="backLine">
                    <button onClick={() => {
                        navigate("/dessertsMenus");
                    }}>Go Back
                    </button>
                </div>
            )
        }
        else if(meal.category.name == "Salads") {
            backButton = (
                <div className="backLine">
                    <button onClick={() => {
                        navigate("/saladsMenus");
                    }}>Go Back
                    </button>
                </div>
            )
        }
        else if(meal.category.name == "Pasta") {
            backButton = (
                <div className="backLine">
                    <button onClick={() => {
                        navigate("/pastaMenus");
                    }}>Go Back
                    </button>
                </div>
            )
        }
        else if(meal.category.name == "Pizza") {
            backButton = (
                <div className="backLine">
                    <button onClick={() => {
                        navigate("/pizzaMenus");
                    }}>Go Back
                    </button>
                </div>
            )
        }
        return (
            <div className="mainBody">
                <br/>
                <center>
                    {backButton}
                <h2 className="menuTitle">{meal.name.toUpperCase()}</h2><br/>
                  <div className="allDetails">
                      <div>
                          <img src="" alt=""/>
                      </div>
                      <div>
                      <p>{meal.description}</p><br/><br/>
                          <h2>ADDITIONS</h2><br/><br/>
                          <div className="additionsBox">
                              {code}
                          </div>
                </div>
              </div><br/><br/><br/>
                  <div className="quantityAndPrice">
                      {finalPrice}
                      <div><button className="arrowButton" onClick={decreaseNumber}>{decrease}</button> <input type="number" value={numberOfItems} className="mealQuantity"/> <button className="arrowButton" onClick={increaseNumber}>{increase}</button></div>
                  </div><br/><br/>
                    <form onSubmit={addToCart}>
                        <button type="submit" className="normalButton">Add To Cart</button><br/><br/>
                    </form>
                    <p className="WarningMessage">{warning}</p>
              </center><br/><br/><br/><br/>
            </div>
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