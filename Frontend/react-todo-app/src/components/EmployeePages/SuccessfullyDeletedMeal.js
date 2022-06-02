import React, {useState} from "react";
import Cookies from "universal-cookie";
import axios from "axios";
import {useNavigate, useParams} from "react-router-dom";

const SuccessfullyDeletedMeal = (loggedUser) => {
    let navigate = useNavigate();
    let params = useParams();
    return (
        <div className="mainBody">
            <center><br/><br/><br/><br/>
                <h1>{params.name} Successfully Deleted</h1><br/><br/><br/><br/><br/><br/><br/><br/><br/>
                <button  className="normalButton" onClick={() => {navigate("/menusEmployee")}}>Proceed</button>
            </center><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
        </div>
    )
}
export default SuccessfullyDeletedMeal;