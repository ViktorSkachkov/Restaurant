import React, {useState} from "react";
import axios from "axios";
import {useNavigate} from "react-router-dom";
import Cookies from "universal-cookie";


const Register = (updateUser) => {
    const [warning, setWarning] = useState();
    const [loginError, setLoginError] = useState(false);


    const [username, setUsername] = useState();
    const [pwd, setPwd] = useState();
    const [email, setEmail] = useState();
    const [address, setAddress] = useState();
    const [firstName, setFirstName] = useState();
    const [lastName, setLastName] = useState();
    const [phone, setPhone] = useState();
    const [res, setRes] = useState(0);
    const [category, setCategory] = useState("CLIENT");
    let navigate = useNavigate();

    const [signupError, setSignupError] = useState(false);
    const onChangeUsername = event => {
        setUsername(event.target.value);
    }
    const onChangePwd = event => {
        setPwd(event.target.value);
    }
    const onChangeFirstName = event => {
        setFirstName(event.target.value);
    }
    const onChangeLastName = event => {
        setLastName(event.target.value);
    }
    const onChangeEmail = event => {
        setEmail(event.target.value);
    }
    const onChangeAddress = event => {
        setAddress(event.target.value);
    }
    const onChangePhone = event => {
        setPhone(event.target.value);
    }
    /*private String firstName;
private String lastName;
private String email;
private String username;
private String phone;
private String address;
private String pwd;
private String category;*/
    /*function handleSubmit() {
          e.preventDefault();
        //const cookies = new Cookies();
            var data = JSON.stringify({
                "firstName": firstName,
                "lastName": lastName,
                "username": username,
                "pwd": pwd,
                "email": email,
                "address": address,
                "phone": phone,
                "category": category
            });

            var config = {
                method: 'post',
                url: 'http://localhost:8080/users',
                headers: {
                    'Content-Type': 'application/json'
                },
                data: data
            };
            axios(config)
                .then(function (response) {
                    setRes(response.data)
                    console.log(response.data)
                    navigate("/");
                    //if (response.data) {
                        //cookies.set("accessToken", response.data.accessToken, { path: '/' });
                       // updateUser.updateUser();
                        //navigate("/");
                    } else {
                        setSignupError(true);
                        throw new Error("Error");
                    }
                })
                .catch(function (error) {
                    console.log(error);
                });
    }*/
    /*<div className="registerItem">
        </div>
         className="registerField"
          className="containerRegister"*/
    const handleSubmit = (e) => {
        e.preventDefault();
        var data = JSON.stringify({
            "firstName": firstName,
            "lastName": lastName,
            "username": username,
            "pwd": pwd,
            "email": email,
            "address": address,
            "phone": phone,
            "category": category
        });

        var config = {
            method: 'post',
            url: 'http://localhost:8080/users',
            headers: {
                'Content-Type': 'application/json'
            },
            data: data
        };
        axios(config);

navigate("/login");
    }
    return (
        <div className="mainBody">
            <center><br/><br/>
            <h1>
                REGISTER
            </h1><br/><br/>
                <p>Fill in your personal information</p><br/><br/><br/>
                <form onSubmit={handleSubmit}>
                        <label for="username" className="formLabelUsername">Username</label><br/>
                        <input type="text" onChange={onChangeUsername} className="Label"/><br/><br/><br/><br/>

                    <label htmlFor="password" className="formLabelPassword">Password</label><br/>
                    <input type="password" onChange={onChangePwd} className="Label"/><br/><br/><br/><br/>

                    <label htmlFor="firstName" className="formLabelFirstName">First Name</label><br/>
                    <input type="text" onChange={onChangeFirstName} className="Label"/><br/><br/><br/><br/>

                    <label htmlFor="firstName" className="formLabelFirstName">Last Name</label><br/>
                    <input type="text" onChange={onChangeLastName} className="Label"/><br/><br/><br/><br/>

                    <label for="email" className="formLabelEmail">Email</label><br/>
                        <input type="email" onChange={onChangeEmail} className="Label"/><br/><br/><br/><br/>

                        <label for="address" className="formLabelAddress">Address</label><br/>
                        <input type="text" onChange={onChangeAddress}  className="Label"/><br/><br/><br/><br/>

                        <label for="phoneNumber" className="formLabelPhoneNumber">Phone Number</label><br/>
                        <input type="text" onChange={onChangePhone} className="Label"/><br/><br/><br/><br/>
                    <button type="submit" className="normalButton">Submit</button>
                </form>
                <br/><br/><br/><br/>
                <br/><br/><br/><br/><br/><br/><br/>
            </center>
        </div>
    )
}
export default Register