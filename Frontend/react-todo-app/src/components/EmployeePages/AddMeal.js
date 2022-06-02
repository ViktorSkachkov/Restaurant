import React, {useState} from "react";
import {useNavigate} from "react-router-dom";
import axios from "axios";
import Cookies from "universal-cookie";

const AddMeal = (loggedUser) => {
    const [description, setDescription] = useState();
    const [weight, setWeight] = useState();
    const [price, setPrice] = useState();
    const [category, setCategory] = useState("Pizza");
    const [image, setImage] = useState();
    const [name, setName] = useState();
    let navigate = useNavigate();
    const cookies = new Cookies();
    const token = cookies.get("accessToken");
    const handleSubmit = (e) => {
        e.preventDefault();
        const config = {
            headers: { Authorization: `Bearer ${token}` }
        };
        const bodyParams = {
            "category": category,
            "image": image,
            "description": description,
            "weight": weight,
            "price": price,
            "name": name
        };
        axios.post(
            `http://localhost:8080/orders/createMeal`,
            bodyParams,
            config
        )
            .then(function (response) {
            let mealName = response.data.mealName;
                navigate(`/successfullyAddedMeal/${mealName}`);
        })
            .catch(function (error) {
                console.log(error);
            });
    }
    const onChangeDescription = event => {
        setDescription(event.target.value);
    }
    const onChangeWeight = event => {
        setWeight(event.target.value);
    }
    const onChangePrice = event => {
        //setPrice(event.target.value);
        setPrice(event.target.value);
    }
    const onChangeCategory = event => {
        setCategory(event.target.value);
    }
    const onChangeImage = event => {
        setImage(event.target.value);
    }
    const onName = event => {
        setName(event.target.value);
    }
    let selectedCategory = useState();

    if(category == "Pasta") {
        selectedCategory = (
            <select
                className="Label"
                onChange={onChangeCategory}
                required={true}
            >
                <option value={"Pizza"}>Pizza</option>
                <option selected={true} value={"Pasta"}>Pasta</option>
                <option value={"Salads"}>Salads</option>
                <option value={"Desserts"}>Desserts</option>
            </select>
        )
    }
    if(category == "Salads") {
        selectedCategory = (
            <select
                className="Label"
                onChange={onChangeCategory}
                required={true}
            >
                <option value={"Pizza"}>Pizza</option>
                <option value={"Pasta"}>Pasta</option>
                <option selected={true} value={"Salads"}>Salads</option>
                <option value={"Desserts"}>Desserts</option>
            </select>
        )
    }
    if(category == "Desserts") {
        selectedCategory = (
            <select
                className="Label"
                onChange={onChangeCategory}
                required={true}
            >
                <option value={"Pizza"}>Pizza</option>
                <option value={"Pasta"}>Pasta</option>
                <option value={"Salads"}>Salads</option>
                <option selected={true} value={"Desserts"}>Desserts</option>
            </select>
        )
    }
    else {
        selectedCategory = (
            <select
                className="Label"
                onChange={onChangeCategory}
                required={true}
            >
                <option selected={true} value={"Pizza"}>Pizza</option>
                <option value={"Pasta"}>Pasta</option>
                <option value={"Salads"}>Salads</option>
                <option value={"Desserts"}>Desserts</option>
            </select>
        )
    }
    return (
        <div className="mainBody">
            <br/>
            <div className="backLine">
                <button onClick={() => {
                    navigate("/menusEmployee");
                }}>Go Back</button>
            </div>
            <center>
                <h1>Add Meal</h1><br/>
                <img src="" alt=""/>
                <form onSubmit={handleSubmit}>
                    <label htmlFor="image" className="formLabelImage">Image</label><br/><br/>
                    <input type="file" onChange={onChangeImage} required={true} className="Label"/><br/><br/><br/><br/>
                    <label htmlFor="name" className="formLabelName">Name</label><br/><br/>
                    <input type="text" onChange={onName} value={name} required={true} className="Label" /><br/><br/><br/><br/>
                    <label htmlFor="description" className="formLabelDescription">Description</label><br/><br/>
                    <input type="text" onChange={onChangeDescription} value={description} required={true} className="Label" /><br/><br/><br/><br/>
                    <label htmlFor="weight" className="formLabelWeight">Weight</label><br/><br/>
                    <input type="number" onChange={onChangeWeight} value={weight} required={true} className="Label" /><br/><br/><br/><br/>
                    <label htmlFor="price" className="formLabelPrice">Price</label><br/><br/>
                    <input type="number" onChange={onChangePrice} value={price} required={true} className="Label" /><br/><br/><br/><br/>
                    <label htmlFor="category" className="formLabelCategory">Category</label><br/><br/>
                    {selectedCategory}<br/>
                    <br/><br/>
                    <button type="submit" className="normalButton">Submit</button>
                </form><br/><br/>
            </center>
        </div>
    )
}
export default AddMeal;