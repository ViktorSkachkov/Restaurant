import SaladsMenuList from "./SaladsMenuList";
import {useNavigate} from "react-router-dom";

const SaladsMenus = (loggedUser) => {
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
            <h2 className="menuTitle">SALADS</h2>
            <div className="menuList">
                    <SaladsMenuList

                    />
            </div>
            </center>
        </div>
    )
}
export default SaladsMenus