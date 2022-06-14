import {useNavigate, useParams} from "react-router-dom";
import React from "react";

const SuccessfullyAddedCartItem = (loggedUser) => {
    let navigate = useNavigate();
    let params = useParams();
    return (
        <div className="mainBody">
            <center><br/><br/><br/><br/>
                <h1>{params.number} Units Of {params.name} Successfully Added To Cart</h1><br/><br/><br/><br/><br/><br/><br/><br/><br/>
                <button  className="normalButton" onClick={() => {navigate(`/menus`)}}>Proceed</button>
            </center><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
        </div>
    )
}
export default SuccessfullyAddedCartItem;