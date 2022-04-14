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
            <h2 className="menuTitle">Pizza</h2>
            <div className="menuList">
                <center>
                    <PizzaMenuList

                    />
                </center>
            </div>
        </>
    )
}
export default PizzaMenus