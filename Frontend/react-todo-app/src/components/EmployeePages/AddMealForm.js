import {useNavigate, useParams} from "react-router-dom";
import React, {useEffect, useState} from "react";
import Cookies from "universal-cookie";
import axios from "axios";

const AddMealForm = (props) => {
    let navigate = useNavigate();
    const cookies = new Cookies();
    const token = cookies.get("accessToken");
    /*let imageComponent;
    if(images.length != 0) {
        imageComponent = (
            <img src={images.at(0)} alt=""/>
        )
    }
    else (
        imageComponent = (
            <></>
        )
    )*/
    const postMeal = (mealObject) => {
       /* axios
            .post("http://localhost:8080/orders/createMeal", mealObject, {
                headers: {
                    headers: { Authorization: `Bearer ${token}` }
                },
            })
            .then((response) => {
                let mealName = response.data.mealName;
                navigate(`/successfullyAddedMeal/${mealName}`);
            })*/
        const config = {
            headers: { Authorization: `Bearer ${token}` }
        };
        const bodyParams = mealObject;
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
            })

    };
    const handleSubmit = (e) => {
        e.preventDefault();

       const category = props.category;
       const  image = props.image;
        const  description = props.description;
        const  weight = props.weight;
        const  price = props.price;
        const  name = props.name;

        const mealObject = {
            category,
            image,
            description,
            weight,
            price,
            name
        };
        postMeal(mealObject);
    }
    const onChangeDescription = event => {
        props.updateDescription(event.target.value);
    }
    const onChangeWeight = event => {
        props.updateWeight(event.target.value);
    }
    const onChangePrice = event => {
        //setPrice(event.target.value);
        props.updatePrice(event.target.value);
    }
    const onChangeCategory = event => {
        props.updateCategory(event.target.value);
    }
    const onChangeImage = (event) => {
        var reader = new FileReader();
        reader.onload = function (event) {
            props.updateImage(event.target.result);
        };
        reader.readAsDataURL(event.target.files[0]);
    }
    const onName = event => {
        props.updateName(event.target.value);
    }
    let selectedCategory = useState();

    if(props.category == "Pasta") {
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
    if(props.category == "Salads") {
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
    if(props.category == "Desserts") {
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
                name="category"
                required={true}
            >
                <option selected={true} value={"Pizza"}>Pizza</option>
                <option value={"Pasta"}>Pasta</option>
                <option value={"Salads"}>Salads</option>
                <option value={"Desserts"}>Desserts</option>
            </select>
        )
    }
    console.log("image");
    console.log(props.image);
   return (
    <center>
        <h1>Add Meal</h1><br/>
        <img src={props.image} name="image" height="100vh" width="100vw" alt=""/>
        <form onSubmit={handleSubmit}>
            <label htmlFor="image" className="formLabelImage">Image</label><br/><br/>
            <input type="file" name="image" onChange={(e) => {
                onChangeImage(e);
            }} required={true} accept="image/*" className="Label"/><br/><br/><br/><br/>
            <label htmlFor="name" className="formLabelName">Name</label><br/><br/>
            <input type="text" name="name" onChange={onName} value={props.name} required={true} className="Label" /><br/><br/><br/><br/>
            <label htmlFor="description" className="formLabelDescription">Description</label><br/><br/>
            <input type="text" name="description" onChange={onChangeDescription} value={props.description} required={true} className="Label" /><br/><br/><br/><br/>
            <label htmlFor="weight" className="formLabelWeight">Weight</label><br/><br/>
            <input type="number" name="weight" onChange={onChangeWeight} value={props.weight} required={true} className="Label" /><br/><br/><br/><br/>
            <label htmlFor="price" className="formLabelPrice">Price</label><br/><br/>
            <input type="number" name="price" onChange={onChangePrice} value={props.price} required={true} className="Label" /><br/><br/><br/><br/>
            <label htmlFor="category" className="formLabelCategory">Category</label><br/><br/>
            {selectedCategory}<br/>
            <br/><br/>
            <button type="submit" className="normalButton">Submit</button>
        </form><br/><br/>
    </center>
   )
}
export default AddMealForm