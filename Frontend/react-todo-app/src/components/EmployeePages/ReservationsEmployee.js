
import React from "react";
import ReservationsList from "./ReservationsList";
import {bindReporter} from "web-vitals/dist/modules/lib/bindReporter";
import {useNavigate} from "react-router-dom";

const ReservationsEmployee = (loggedUser) => {
    return (
        <div className="mainBody">
            <center><br/><br/>
                <h1>View Reservations</h1><br/>
                <ReservationsList/><br/><br/><br/><br/><br/><br/>
            </center>
        </div>
    )
}
export default ReservationsEmployee