import {useNavigate, useParams} from "react-router-dom";
import React from "react";

const SuccessfullyAddedReservation = (loggedUser) => {
    let navigate = useNavigate();
    return (
        <div className="mainBody">
            <center><br/><br/><br/><br/>
                <h1>Reservation Successfully Added</h1><br/><br/><br/><br/><br/><br/><br/><br/><br/>
                <button  className="normalButton" onClick={() => {navigate("/reservation")}}>Proceed</button>
            </center><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
        </div>
    )
}
export default SuccessfullyAddedReservation;