import PastaMenuList from "./PastaMenuList";
import {useNavigate} from "react-router-dom";



const PastaMenus = (loggedUser) => {
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
                <h2 className="menuTitle">PASTA</h2>
                <div className="menuList">
                        <PastaMenuList

                        />
                </div>
                </center>
            </div>
        )
}
export default PastaMenus