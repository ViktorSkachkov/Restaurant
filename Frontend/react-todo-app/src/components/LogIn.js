import React, {useEffect, useState} from "react";
import {useNavigate} from "react-router-dom";
import axios from "axios";
import Cookies from "universal-cookie";

const LogIn = (updateUser) => {
    let navigate = useNavigate();

    const [username, setUsername] = useState();
    const [pwd, setPwd] = useState();
    const [warning, setWarning] = useState();

    const [loginError, setLoginError] = useState(false);

    /*const onChange = event => {
        setFormValue({
            ...formValue,
            [event.target.name]: event.target.value
        })
    }*/
    const onChangeUsername = event => {
        setUsername(event.target.value);
    }
    const onChangePwd = event => {
        setPwd(event.target.value);
    }
    const handleSubmit = (e) => {
        e.preventDefault();
        const cookies = new Cookies();
        var data = JSON.stringify({
            "username": username,
            "pwd": pwd
        });

        var config = {
            method: 'post',
            url: 'http://localhost:8080/login',
            headers: {
                'Content-Type': 'application/json'
            },
            data: data
        };


        axios(config)
            .then(function (response) {
                cookies.set("accessToken", response.data.accessToken, { path: '/' });
                updateUser.updateUser();
                navigate("/");
            })
            .catch(function (error) {
                setLoginError(true);
                console.log(error);
                setWarning("Incorrect login details");
            });
    }
    return (
        <div className="mainBody">
            <center><br/><br/>
            <h1>
                LOGIN
            </h1><br/><br/>
            <p>Fill in your personal information</p><br/><br/><br/>
            <form onSubmit={handleSubmit}>
                <label for="username" className="formLabelUsername">Username</label><br/>
                <input type="text" onChange={onChangeUsername} className="Label"/><br/><br/><br/><br/>
                <label for="password" className="formLabelPassword">Password</label><br/>
                <input type="password" onChange={onChangePwd} className="Label"/>
                <br/><br/><br/><br/>
                <button type="submit" className="normalButton">Submit</button>
            </form>
            <br/><br/>
            <p>If you don't have an account yet, please, <i><div className="register" onClick={() => {
                navigate("/register");
            }}>
                register
            </div></i></p><br/>
                <p className="WarningMessage">{warning}</p>
            </center>
            <br/><br/><br/><br/><br/><br/><br/>
        </div>
    )
}
export default LogIn