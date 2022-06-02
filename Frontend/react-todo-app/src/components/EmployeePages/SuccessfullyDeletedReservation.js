import {useNavigate, useParams} from "react-router-dom";
import React from "react";

const SuccessfullyDeletedReservation = (loggedUser) => {
    let navigate = useNavigate();
    let params = useParams();
    return (
        <div className="mainBody">
            <center><br/><br/><br/><br/>
                <h1>Reservation Successfully Rejected</h1><br/><br/>
                <p>Call number {params.phone} to inform them about the rejection of their reservation.</p><br/><br/><br/><br/><br/><br/><br/>
                <button  className="normalButton" onClick={() => {navigate("/reservationsEmployee")}}>Proceed</button>
            </center><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
        </div>
    )
}
export default SuccessfullyDeletedReservation;