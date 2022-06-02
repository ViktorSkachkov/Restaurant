import {useNavigate, useParams} from "react-router-dom";
import React from "react";

const SuccessfullyCompletedOrder = (loggedUser) => {
    let navigate = useNavigate();
    return (
        <div className="mainBody">
            <center><br/><br/><br/><br/>
                <h1>Order Successfully Completed</h1><br/><br/><br/><br/><br/><br/><br/><br/><br/>
                <button  className="normalButton" onClick={() => {navigate("/ordersEmployee")}}>Proceed</button>
            </center><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
        </div>
    )
}
export default SuccessfullyCompletedOrder;