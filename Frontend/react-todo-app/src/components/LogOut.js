import React, {useEffect, useState} from "react";
import {useNavigate} from "react-router-dom";
import axios from "axios";
import Cookies from "universal-cookie";

const LogOut = (removeUser) => {
    let navigate = useNavigate();

    /*useEffect(() => {
        const cookies = new Cookies();
        cookies.remove("accessToken", { path: '/' });
        removeUser.removeUser();
        navigate("/");
    }, [navigate, removeUser]);*/
    const logOut = () => {
        const cookies = new Cookies();
        cookies.remove("accessToken", { path: '/' });
        removeUser.removeUser();
        navigate("/");
    }

    return (
        <div className="mainBody">
            <center><br/><br/>
                <h1>
                    LOGOUT
                </h1><br/><br/>
                <p>Are you sure you want to log out?</p><br/><br/><br/>
                <div className="logoutButtons">
                    <button  className="normalButton" onClick={logOut}>Yes</button>
                    <button className="normalButton" onClick={() => {
                        navigate(`/`, {

                        });
                    }}>No</button>
                </div>
            </center>
            <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
        </div>
    )
}
export default LogOut