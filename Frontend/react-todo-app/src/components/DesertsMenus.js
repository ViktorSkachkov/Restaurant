import DesertsMenuList from "./DesertsMenuList";
import {useNavigate} from "react-router-dom";


const DesertsMenus = (loggedUser) => {
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
            <h2 className="menuTitle">DESSERTS</h2><br/>
            <div className="menuList">
                    <DesertsMenuList

                    />

            </div>
            </center>
        </div>
    )
}
export default DesertsMenus