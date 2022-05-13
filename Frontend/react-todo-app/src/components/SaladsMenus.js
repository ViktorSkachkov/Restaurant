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
            <center>
            <h2 className="menuTitle">SALADS</h2>
            <div className="menuList">
                    <SaladsMenuList

                    />
            </div>
            </center>
        </>
    )
}
export default SaladsMenus