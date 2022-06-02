import React, {useState} from "react";
import {Link, NavLink, BrowserRouter as Router, Routes, Route, useNavigate} from "react-router-dom";
import Footer from "./Footer";
import InfoForPizzaMeal from "./InfoForPizzaMeal";
import HowToOrder from "./HowToOrder";
import AboutUs from "./AboutUs";
import Reservation from "./Reservation";
import LogIn from "./LogIn";
import Register from "./Register";
import Menus from "./Menus";
import PastaMenus from "./PastaMenus";
import PizzaMenus from "./PizzaMenus";
import SaladsMenus from "./SaladsMenus";
import DesertsMenus from "./DesertsMenus";
import Details from "./Details";
import Cart from "./Cart";
import pizzaImage from "./pictures/Pizza.jpg"
import pizzaImage2 from "./pictures/People_Eating_Pizza.jpg"
import axios from "axios";
import Cookies from "universal-cookie";
import jwtDecode from "jwt-decode";
import logoImage from "./pictures/logo.png";
import Home from "./Home";
import Contacts from "./Contacts";
import Navigation from "./Navigation";
import LogOut from "./LogOut";
import AssignTables from "./EmployeePages/AssignTables";
import ReservationsEmployee from "./EmployeePages/ReservationsEmployee";
import MenusEmployee from "./EmployeePages/MenusEmployee";
import UpdateMeal from "./EmployeePages/UpdateMeal";
import AddMeal from "./EmployeePages/AddMeal";
import Sales from "./EmployeePages/Sales";
import SuccessfullyDeletedMeal from "./EmployeePages/SuccessfullyDeletedMeal";
import SuccessfullyAddedMeal from "./EmployeePages/SuccessfullyAddedMeal";
import SuccessfullyUpdatedMeal from "./EmployeePages/SuccessfullyUpdatedMeal";
import SuccessfullyDeletedReservation from "./EmployeePages/SuccessfullyDeletedReservation";
import SuccessfullyAssignedTable from "./EmployeePages/SuccessfullyAssignedTable";
import SuccessfullyAddedReservation from "./SuccessfullyAddedReservation";
import SuccessfullyAddedCartItem from "./SuccessfullyAddedCartItem";
import CartList from "./CartList";
import OrdersEmployee from "./EmployeePages/OrdersEmployee";
import SuccessfullyCompletedOrder from "./EmployeePages/SuccessfullyCompletedOrder";
//import i18n from './i18n';

const Index = () => {
    const [loggedUser, setLoggedUser] = useState(null);
    const [expirationDate, setExpirationDate] = useState(null);

    /*const [locale, setLocale] = useState(i18n.language);
    i18n.on('languageChanged', (lng) => setLocale(i18n.language));*/

    const updateUser = () => {
        const cookies = new Cookies();
        const token = cookies.get("accessToken");
        console.log("token: " + token)
        var decode = jwtDecode(token);
        console.log(decode)
        const userID = decode.userId;
        console.log("userId: " + userID)

        var config = {
            method: "get",
            url: `http://localhost:8080/users/${userID}`,
            headers: {
                "Authorization": `Bearer ${token}`,
            },
        };

        axios(config)
            .then(function (response) {
                const cookies = new Cookies();
                const token = cookies.get("accessToken");
                var decode = jwtDecode(token);
                setExpirationDate(decode.exp);
                setLoggedUser(response.data);
            })
            .catch(function (error) {
                console.log(error);
            });
    };

    const removeUser = () => {
        setLoggedUser(null);
        setExpirationDate(null);
    };

    const checkTokenExpiration = () => {
        if (expirationDate) {
            const currentTime = new Date().getTime() / 1000;
            if (currentTime > expirationDate) {
                removeUser();
            }
        }
    };
    return (
        <>
            <Router>
            <Navigation
                loggedUser={loggedUser}
                checkTokenExpiration={checkTokenExpiration}
            />

                <Routes>
                    <Route path="/" element={<Home loggedUser={loggedUser} />}/>
                    <Route path="/contacts" element={<Contacts loggedUser={loggedUser} />}/>
                    <Route path="/reservation" element={<Reservation loggedUser={loggedUser} />}/>
                    <Route path="/aboutUs" element={<AboutUs loggedUser={loggedUser} />}/>
                    <Route path="/howToOrder" element={<HowToOrder loggedUser={loggedUser} />}/>
                    <Route path="/menus" element={<Menus loggedUser={loggedUser} />}/>
                    <Route path="/saladsMenus" element={<SaladsMenus loggedUser={loggedUser} />}/>
                    <Route path="/dessertsMenus" element={<DesertsMenus loggedUser={loggedUser} />}/>
                    <Route path="/pastaMenus" element={<PastaMenus loggedUser={loggedUser} />}/>
                    <Route path="/pizzaMenus" element={<PizzaMenus loggedUser={loggedUser} />}/>
                    <Route path="/logIn" element={<LogIn updateUser={updateUser} />}/>
                    <Route path="/logOut" element={<LogOut removeUser={removeUser} />}/>
                    <Route path="/cart" element={<Cart loggedUser={loggedUser} />}/>
                    <Route path="/register" element={<Register loggedUser={updateUser} />}/>
                    <Route path="/details/:id" element={<Details loggedUser={loggedUser} />}/>
                    <Route path="/navigation" element={<Navigation loggedUser={loggedUser} />}/>

                    <Route path="/assignTables/:id" element={<AssignTables loggedUser={loggedUser} />}/>
                    <Route path="/reservationsEmployee" element={<ReservationsEmployee loggedUser={loggedUser}/>}/>
                    <Route path="/menusEmployee" element={<MenusEmployee loggedUser={updateUser}/>}/>
                    <Route path="/updateMeal/:id" element={<UpdateMeal loggedUser={loggedUser}/>}/>
                    <Route path="/addMeal" element={<AddMeal loggedUser={loggedUser}/>}/>
                    <Route path="/sales" element={<Sales loggedUser={loggedUser}/>}/>
                    <Route path="/ordersEmployee" element={<OrdersEmployee loggedUser={loggedUser}/>}/>
                    <Route path="/successfullyDeletedMeal/:name" element={<SuccessfullyDeletedMeal loggedUser={loggedUser}/>}/>
                    <Route path="/successfullyAddedMeal/:name" element={<SuccessfullyAddedMeal loggedUser={loggedUser}/>}/>
                    <Route path="/successfullyUpdatedMeal/:name" element={<SuccessfullyUpdatedMeal loggedUser={loggedUser}/>}/>
                    <Route path="/successfullyDeletedReservation" element={<SuccessfullyDeletedReservation loggedUser={loggedUser}/>}/>
                    <Route path="/successfullyAssignedTable/:id" element={<SuccessfullyAssignedTable loggedUser={loggedUser}/>}/>
                    <Route path="/successfullyAddedReservation" element={<SuccessfullyAddedReservation loggedUser={loggedUser}/>}/>
                    <Route path="/successfullyAddedCartItem/:name/:number/:detailsId" element={<SuccessfullyAddedCartItem loggedUser={loggedUser}/>}/>
                    <Route path="/successfullyCompletedOrder" element={<SuccessfullyCompletedOrder loggedUser={loggedUser}/>}/>
                </Routes>
            </Router>
            <Footer/>
        </>
    )
}

export default Index