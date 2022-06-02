import {useNavigate, useParams} from "react-router-dom";
import React from "react";

const SuccessfullyDeletedReservation = (loggedUser) => {
    let navigate = useNavigate();
    let params = useParams();
    return (
        <div className="mainBody">
            <center><br/><br/><br/><br/>
                <h1>Table Successfully Assigned</h1><br/><br/><br/><br/><br/><br/><br/><br/><br/>
                <button  className="normalButton" onClick={() => {navigate(`/assignTables/${params.id}`)}}>Proceed</button>
            </center><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
        </div>
    )
}
export default SuccessfullyDeletedReservation;