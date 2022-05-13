import DesertsMenuList from "./DesertsMenuList";
import {useNavigate} from "react-router-dom";


function DesertsMenus() {
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
            <h2 className="menuTitle">DESSERTS</h2>
            <div className="menuList">
                    <DesertsMenuList

                    />

            </div>
            </center>
        </>
    )
}
export default DesertsMenus