import SaladsMenuList from "./SaladsMenuList";
import {useNavigate} from "react-router-dom";

function SaladsMenus() {
    let navigate = useNavigate();
    return (

        <>
            <br/>
            <div className="backLine">
                <button onClick={() => {
                    navigate("/menus");
                }}>Go Back</button>
            </div>
            <h2 className="menuTitle">Salads</h2>
            <div className="menuList">
                <center>
                    <SaladsMenuList

                    />
                </center>
            </div>
        </>
    )
}
export default SaladsMenus