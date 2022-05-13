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
                <center>
                <h2 className="menuTitle">PASTA</h2>
                <div className="menuList">
                        <PastaMenuList

                        />
                </div>
                </center>
            </>
        )
}
export default PastaMenus