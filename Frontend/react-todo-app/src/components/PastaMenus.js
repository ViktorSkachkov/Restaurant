import PastaMenuList from "./PastaMenuList";
import {useNavigate} from "react-router-dom";



function PastaMenus() {
    let navigate = useNavigate();
        return (

            <>
                <br/>
                <div className="backLine">
                    <button onClick={() => {
                        navigate("/menus");
                    }}>Go Back</button>
                </div>
                <h2 className="menuTitle">Pasta</h2>
                <div className="menuList">
                    <center>
                        <PastaMenuList

                        />
                    </center>
                </div>
            </>
        )
}
export default PastaMenus