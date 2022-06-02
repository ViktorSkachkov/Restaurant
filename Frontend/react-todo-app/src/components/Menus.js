import React, {useState} from "react";
import CategoryList from "./CategoryList";

function Menus() {

    return(
        <div className="mainBody">
            <center><br/><br/>
            <h1>
                MENU
            </h1><br/><br/>
                <p>Order for your home or office</p><br/><br/><br/>
                <div className="menuList">
            <CategoryList/><br/>
                </div>
            <h5>BEST OFFERS</h5><br/>
            </center><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
    </div>
    )
}

export default Menus

