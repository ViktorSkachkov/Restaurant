import Navbar from "./Navbar";
import MenuList from "./MenuList";
import Footer from "./Footer";
import Details from "./Details";

const InfoForPizzaMeal = () => {
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
                    <Details/>
                </center>
            </div>
            <Footer/>
        </>
    )
}