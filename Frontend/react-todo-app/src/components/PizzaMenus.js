import PizzaMenuList from "./PizzaMenuList";
import {useNavigate} from "react-router-dom";


function PizzaMenus() {
    let navigate = useNavigate();
    return (

        <>
            <br/>
            <div className="backLine">
                <button onClick={() => {
                    navigate("/menus");
                }}>Go Back</button>
            </div>
            <center>
            <h2 className="menuTitle">PIZZA</h2>
            <div className="menuList">
                    <PizzaMenuList

                    />
            </div>
            </center>
        </>
    )
}
export default PizzaMenus