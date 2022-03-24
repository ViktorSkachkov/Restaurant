import React, {useState} from "react"
import MenuItem from "./MenuItem";
import axios from "axios";

function MenuList() {
    const [ids, setIds] = useState([]);
    const [images, setImages] = useState([]);
    const [names, setNames] = useState([]);
    const [descriptions, setDescriptions] = useState([]);
    const [weights, setWeights] = useState([]);
    const [prices, setPrices] = useState([]);
    axios.defaults.baseURL = "http://localhost:8080";

    /*let item =
        {
            id: 0,
            image: '',
            name: '',
            description: '',
            weight: 0,
            price: 0
        }*/


    function getMeals() {
        const getMeals = [];
        axios.get('/individualTrack/getIds').then(res => {setIds(res.data)})
        axios.get('/individualTrack/getNames').then(res => {setNames(res.data)})
        axios.get('/individualTrack/getImages').then(res => {setImages(res.data)})
        axios.get('/individualTrack/getDescriptions').then(res => {setDescriptions(res.data)})
        axios.get('/individualTrack/getWeights').then(res => {setWeights(res.data)})
        axios.get('/individualTrack/getPrices').then(res => {setPrices(res.data)})

        /*for(let i = 0; i < ids.length; i++) {
            item.id = ids.at(i);
            item.image = images.at(i);
            item.name = names.at(i);
            item.description = descriptions.at(i);
            item.weight = weights.at(i);
            item.price = prices.at(i);
        }*/
    }
    let code = [];
    let component;
    for(let i = 0; i < ids.length; i++) {
        component = (
            <div className="menuItem">
                <img src={images.at(i)} alt=""/>
                <br/>
                <h3>{names.at(i)}</h3>
                <br/>
                <p>{descriptions.at(i)}</p>
                <br/>
                <div className="weightAndPrice">
                    <p>
                        {weights.at(i)}
                    </p>
                    <p>
                        {prices.at(i)} €
                    </p>
                </div>
                <br/>
                <br/>
                <div className="menuButtons">
                    <button key={ids.at(i)}><a href="">Details ></a></button>
                    <button key={ids.at(i)}><a href="">Add to cart ></a></button>
                </div>
            </div>
        )
        code.push(component);
    }
    return (
        <>
            {code}
            <div>
                <button onClick={getMeals}>Click me</button>
            </div>
                </>
    )

}



export default MenuList