import {useNavigate, useParams} from "react-router-dom";
import React from "react";

const SuccessfullyUpdatedMeal = (loggedUser) => {
    let navigate = useNavigate();
    let params = useParams();
    return (
        <div className="mainBody">
            <center><br/><br/><br/><br/>
                <h1>{params.name} Successfully Updated</h1><br/><br/><br/><br/><br/><br/><br/><br/><br/>
                <button className="normalButton" onClick={() => {navigate("/menusEmployee")}}>Proceed</button>
            </center><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
        </div>
    )
}
export default SuccessfullyUpdatedMeal;