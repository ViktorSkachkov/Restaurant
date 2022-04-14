import React, {useState} from "react";
import CategoryList from "./CategoryList";

function Menus() {

    return(
        <>
            <center>
            <h1 className="menuTitle">
                Menu
            </h1><br/><br/>
                <p>Order for your home or office</p><br/><br/><br/>
                <div className="menuList">
            <CategoryList/><br/>
                </div>
            <h5>BEST OFFERS</h5><br/>
            </center>
    </>
    )
}

export default Menus

