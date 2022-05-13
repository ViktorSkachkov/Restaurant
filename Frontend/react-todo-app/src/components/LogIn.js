import React, {useState} from "react";
import {useNavigate} from "react-router-dom";

function LogIn() {
    let navigate = useNavigate();
    return (
        <>
            <center><br/><br/>
            <h1>
                LOGIN
            </h1><br/><br/>
            <p>Fill in your personal information</p><br/><br/><br/>
            <form method="post">
                <label for="username" className="formLabelUsername">Username</label><br/>
                <input type="text" className="Label"/><br/><br/><br/><br/>
                <label for="password" className="formLabelPassword">Password</label><br/>
                <input type="password" className="Label"/>
                <br/><br/><br/><br/>
                <button className="normalButton">Submit</button>
            </form>
            <br/><br/>
            <p>If you don't have an account yet, please, <i><div className="register" onClick={() => {
                navigate("/register");
            }}>
                register
            </div></i></p>
            </center>
            <br/><br/><br/><br/><br/><br/><br/>
        </>
    )
}
export default LogIn