import Navbar from "./Navbar";
import Footer from "./Footer";
import MenuList from  "./MenuList";
import axios from "axios";
import {useEffect, useState} from "react";


function PizzaMenus() {
    /*let state = {
        menus: [
            {
                id: 1,
                image: './pictures/lasagna.jpg',
                name: 'Lasagna',
                description: 'tomatoes, beef, parmesan, mozzarella, onion, garlic, parsley, oregano, bell pepper',
                weight: '400g',
                price: 8.99
            },
            {
                id: 2,
                image: 'src/pictures/lasagna.jpg',
                name: 'Lasagna',
                description: 'tomatoes, beef, parmesan, mozzarella, onion, garlic, parsley, oregano, bell pepper',
                weight: '400g',
                price: 8.99
            },
            {
                id: 3,
                image: 'src/pictures/lasagna.jpg',
                name: 'Lasagna',
                description: 'tomatoes, beef, parmesan, mozzarella, onion, garlic, parsley, oregano, bell pepper',
                weight: '400g',
                price: 8.99
            },
            {
                id: 4,
                image: 'src/pictures/lasagna.jpg',
                name: 'Lasagna',
                description: 'tomatoes, beef, parmesan, mozzarella, onion, garlic, parsley, oregano, bell pepper',
                weight: '400g',
                price: 8.99
            },
            {
                id: 5,
                image: 'src/pictures/lasagna.jpg',
                name: 'Lasagna',
                description: 'tomatoes, beef, parmesan, mozzarella, onion, garlic, parsley, oregano, bell pepper',
                weight: '400g',
                price: 8.99
            },
            {
                id: 6,
                image: 'src/pictures/lasagna.jpg',
                name: 'Lasagna',
                description: 'tomatoes, beef, parmesan, mozzarella, onion, garlic, parsley, oregano, bell pepper',
                weight: '400g',
                price: 8.99
            },
            {
                id: 7,
                image: 'src/pictures/lasagna.jpg',
                name: 'Lasagna',
                description: 'tomatoes, beef, parmesan, mozzarella, onion, garlic, parsley, oregano, bell pepper',
                weight: '400g',
                price: 8.99
            }
        ]
    };*/
    /*const [summon2, setSummon2] = useState([]);
    let config2 = {
        method: 'get',
        url: 'http://localhost:8080/individualTrack/getNumbers',
        headers: {"Access-Control-Allow-Origin": "*"}
    };
    axios(config2)
        .then(function (response) {
            setSummon2(response.data);
        })
        .catch(function (error) {
            console.log(error)
        });*/
    const [summon, setSummon] = useState([]);
    axios.defaults.baseURL = "http://localhost:8080";
    const Numbers = [];
    function getNumbers() {
        axios.get('/individualTrack/getNumbers').then(res => {setSummon(res.data)})
    }
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
                        <MenuList

                        />
                    </center>
                </div>
                {summon.map(number => {
                    return (
                        <div>
                            <p>{number}</p>
                        </div>
                    )
                })}
                <button onClick={getNumbers}>Display numbers</button>
                <Footer/>
            </>
        )
}
export default PizzaMenus