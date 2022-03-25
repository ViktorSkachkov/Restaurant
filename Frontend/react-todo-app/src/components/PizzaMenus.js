import Navbar from "./Navbar";
import Footer from "./Footer";
import MenuList from  "./MenuList";
import axios from "axios";
import {useEffect, useState} from "react";


function PizzaMenus() {
        return (

            <>
                <Navbar/>
                <br/>
                <div className="backLine">
                    <button>Go Back</button>
                </div>
                <h2 className="menuTitle">Pizza</h2>
                <div className="menuList">
                    <center>
                        <MenuList

                        />
                    </center>
                </div>
                <Footer/>
            </>
        )
}
export default PizzaMenus
