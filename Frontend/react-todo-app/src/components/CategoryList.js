import React, {useEffect, useState} from "react";
import axios from "axios";
import {useNavigate} from "react-router-dom";

function CategoryList() {
    let navigate = useNavigate();
    const [categories, setCategories] = useState([]);
    /*const [ids, setIds] = useState([]);
    const [images, setImages] = useState([]);
    const [names, setNames] = useState([]);*/
    axios.defaults.baseURL = "http://localhost:8080";

    useEffect(() => {
        getCategories();
    })
    function getCategories() {
        axios.get('orders/Categories').then(res => {setCategories(res.data)})
        /*axios.get('/individualTrack/categoryIds').then(res => {setIds(res.data)})
        axios.get('/individualTrack/categoryNames').then(res => {setNames(res.data)})
        axios.get('/individualTrack/categoryImages').then(res => {setImages(res.data)})*/
    }
    let code = [];
    let component;
    let part;
    for(let i = 0; i < categories.length; i++) {
        switch (categories.at(i).name) {
            case "Pizza":
                part =( <button className="categoryItemButton" key={categories.at(i).id} onClick={() => {
                    navigate("/pizzaMenus")
                }}>VIEW MORE</button>);
            break;
            case "Pasta":
                part =( <button className="categoryItemButton" key={categories.at(i).id} onClick={() => {
                    navigate("/pastaMenus")
                }}>VIEW MORE</button>);
                break;
            case "Salads":
                part =( <button className="categoryItemButton" key={categories.at(i).id} onClick={() => {
                    navigate("/saladsMenus")
                }}>VIEW MORE</button>);
                break;
            case "Deserts":
                part = ( <button className="categoryItemButton" key={categories.at(i).id} onClick={() => {
                    navigate("/desertsMenus")
                }}>VIEW MORE</button>);
                break;
        }
            component = (
                <>
                    <div className="menuItem" key={categories.at(i).id}>
                        <img src={categories.at(i).image} alt=""/>
                        <br/>
                        <h3>{categories.at(i).name}</h3>
                        <br/>
                        <div className="menuButtons">
                            {part}
                        </div>
                    </div>
                </>
            )
    code.push(component);
    }
    return (
        <>
            {code}
        </>
    )
}

export default CategoryList