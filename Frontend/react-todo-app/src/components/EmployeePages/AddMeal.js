import React, {useState} from "react";
import {useNavigate} from "react-router-dom";
import axios from "axios";
import Cookies from "universal-cookie";
import AddMealForm from "./AddMealForm";

const AddMeal = (loggedUser) => {
    const [description, setDescription] = useState();
    const [weight, setWeight] = useState();
    const [price, setPrice] = useState();
    const [category, setCategory] = useState("Pizza");
    const [image, setImage] = useState();
    const [image2, setImage2] = useState([]);
    const [images, setImages] = useState([]);
    const [name, setName] = useState();
    let navigate = useNavigate();


    return (
        <div className="mainBody">
            <br/>
            <div className="backLine">
                <button onClick={() => {
                    navigate("/menusEmployee");
                }}>Go Back</button>
            </div>
<AddMealForm
    category = {category}
    image = {image}
    description = {description}
    weight = {weight}
    price = {price}
    name = {name}

    updateCategory = {setCategory}
    updateImage = {setImage}
    updateDescription = {setDescription}
    updateWeight = {setWeight}
    updatePrice = {setPrice}
    updateName = {setName}
/>
        </div>
    )
}
export default AddMeal;