import Navbar from "./Navbar";
import PastaMenuList from "./PastaMenuList";
import Footer from "./Footer";
import Details from "./Details";

const InfoForPizzaMeal = (loggedUser) => {
    return (
        <>
            <Navbar/>
            <br/>
            <div className="backLine">
                <button>Go Back</button>
            </div>
            <h2 className="menuTitle">Pizza</h2>
            <div className="menuList">
                <center>

                </center>
            </div>
            <Footer/>
        </>
    )
}
export default InfoForPizzaMeal;