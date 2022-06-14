import PizzaMenuList from "./PizzaMenuList";
import {useNavigate} from "react-router-dom";


const PizzaMenus = (loggedUser) => {
    let navigate = useNavigate();
    return (

        <div className="mainBody">
            <br/>
            <div className="backLine">
                <button onClick={() => {
                    navigate("/menus");
                }}>Go Back</button>
            </div>
            <center>
            <h2 className="menuTitle">PIZZA</h2><br/>
            <div className="menuList">
                    <PizzaMenuList

                    />
            </div>
            </center>
        </div>
    )
}
export default PizzaMenus