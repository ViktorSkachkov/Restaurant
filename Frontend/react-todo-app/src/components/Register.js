import React, {useState} from "react";


function Register() {
    return (
        <>
            <center><br/><br/>
            <h1>
                REGISTER
            </h1><br/><br/>
                <p>Fill in your personal information</p><br/><br/><br/>
                <form method="post" className="containerRegister">
                    <div className="registerItem">
                        <label for="username" className="formLabelUsername">Username</label><br/>
                        <input type="text" className="registerField" className="Label"/><br/><br/><br/><br/>
                    </div>
                    <div className="registerItem">
                        <label for="email" className="formLabelEmail">Email</label><br/>
                        <input type="email" className="registerField" className="Label"/><br/><br/><br/><br/>
                    </div>
                    <div className="registerItem">
                        <label for="password" className="formLabelPassword">Password</label><br/>
                        <input type="password" className="registerField" className="Label"/><br/><br/><br/><br/>
                    </div>
                    <div className="registerItem">
                        <label for="address" className="formLabelAddress">Address</label><br/>
                        <input type="text" className="registerField" className="Label"/><br/><br/><br/><br/>
                    </div>
                    <div className="registerItem">
                        <label for="firstName" className="formLabelFirstName">First Name</label><br/>
                        <input type="text" className="registerField" className="Label"/><br/><br/><br/><br/>
                    </div>
                    <div className="registerItem">
                        <label for="phoneNumber" className="formLabelPhoneNumber">Phone Number</label><br/>
                        <input type="text" className="registerField" className="Label"/><br/><br/><br/><br/>
                    </div>
                    <div className="registerItem">
                        <label for="lastName" className="formLabelLastName">Last Name</label><br/>
                        <input type="text" className="registerField" className="Label"/><br/><br/><br/><br/>
                    </div>
                </form>
                <br/><br/><br/><br/>
                <button className="normalButton">Submit</button>
                <br/><br/><br/><br/><br/><br/><br/>
            </center>
        </>
    )
}
export default Register