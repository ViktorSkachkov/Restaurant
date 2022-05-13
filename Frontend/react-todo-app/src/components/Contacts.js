import React from "react";
import ErrorMessage from "formik";
const Contacts = (props) =>  {
    return (
        <div className="mainBody">
            <center><br/><br/>
                <h1>CONTACTS</h1><br/><br/>
                <h3>ADDRESS & PHONE</h3><br/><br/>
                <b><p>Kerkstraat 18, 5612 GH Eindhoven, Netherlands</p>
                    <p>Phone: +31 40 209 2300</p></b><br/><br/>
                <h3>YOUR ENQUIRY</h3><br/><br/>
                <form method="post">
                    <label htmlFor="username" className="formLabelName">Name</label><br/>
                    <input type="text" className="Label"/><br/><br/><br/><br/>
                    <label htmlFor="email" className="formLabelEmail">Email</label><br/>
                    <input type="email" className="Label"/><br/><br/><br/><br/>
                    <label htmlFor="enquiry" className="formLabelEnquiry">Enquiry</label><br/>
                    <textarea name="" id="" cols="50" rows="10"></textarea>

                    <br/><br/><br/><br/>
                    <button className="normalButton">Submit</button><br/><br/>
                </form>
            </center>
        </div>
    )
}
export default Contacts