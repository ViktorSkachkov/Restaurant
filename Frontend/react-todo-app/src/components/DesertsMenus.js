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
            <h2 className="menuTitle">Deserts</h2>
            <div className="menuList">
                <center>
                    <DesertsMenuList

                    />
                </center>
            </div>
        </>
    )
}
export default DesertsMenus