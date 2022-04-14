import React, {useState} from "react";
import {useNavigate} from "react-router-dom";

function LogIn() {
    let navigate = useNavigate();
    return (
        <>
            <h1 className="menuTitle">
                Login
            </h1><br/><br/>
            <center>
            <p>Fill in your personal information</p><br/><br/><br/>
            <form method="post">
                <label for="username" className="formLabelUsername">Username</label><br/>
                <input type="text"/><br/><br/><br/><br/>
                <label for="password" className="formLabelPassword">Password</label><br/>
                <input type="password"/>
            </form>
            <br/><br/><br/><br/>
            <button className="normalButton">Submit</button>
            <br/><br/>
            <p>If you don't have an account yet, please, <i><div className="register" onClick={() => {
                navigate("/register");
            }}>
                register
            </div></i></p>
            </center>
            <br/><br/>
        </>
    )
}
export default LogIn