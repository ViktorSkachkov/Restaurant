
import React, {useEffect, useState} from "react";
import {useNavigate, useParams} from "react-router-dom";
import Cookies from "universal-cookie";
import axios from "axios";

const UpdateMeal = (loggedUser) => {
    let navigate = useNavigate();
    let params = useParams();
    const cookies = new Cookies();
    const token = cookies.get("accessToken");
    const [meal, setMeal] = useState();

    const [description, setDescription] = useState();
    const [weight, setWeight] = useState();
    const [price, setPrice] = useState();
    const [category, setCategory] = useState();
    const [image, setImage] = useState();
    const [name, setName] = useState();
    function getMeal() {
        //console.log(params.id)
        var config = {
            method: "get",
            url: `http://localhost:8080/orders/${params.id}`,
            headers: {
                "Authorization": `Bearer ${token}`,
            },
        };

        axios(config)
            .then(function (response) {
                setMeal(response.data);
                console.log(meal);
                let {description, weight, price, name, category, image} = response.data;
                setDescription(description)
                setWeight(weight)
                setPrice(price)
                setName(name)
                setCategory(category.name)
                setImage(image)
            })
            .catch(function (error) {
                console.log(error);
            });
    }
    useEffect(() => {
        getMeal();

    }, [])
    /*useEffect(() => {
        setDescription(meal.description);
    })*/
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
    const onChangeName = event => {
        setName(event.target.value);
    }
    const handleSubmit = (e) => {
        e.preventDefault();
        const config = {
            headers: { Authorization: `Bearer ${token}` }
        };
        const bodyParams = {
            "id": params.id,
            "category": category,
            "image": image,
            "description": description,
            "weight": weight,
            "price": price,
            "name": name
        };
        axios.put(
            `http://localhost:8080/orders/updateMeal`,
            bodyParams,
            config
        )
            .then(function (response) {
                let mealName = response.data.mealName;
                navigate(`/successfullyUpdatedMeal/${mealName}`);
            })
            .catch(function (error) {
                console.log(error);
            });
    }
    let selectedCategory = useState();
    if(category == "Pizza") {
        selectedCategory = (
            <select
                className="Label"
                onChange={onChangeCategory}
            >
                <option selected={true} value={"Pizza"}>Pizza</option>
                <option value={"Pasta"}>Pasta</option>
                <option value={"Salads"}>Salads</option>
                <option value={"Desserts"}>Desserts</option>
            </select>
        )
    }
    if(category == "Pasta") {
        selectedCategory = (
            <select
                className="Label"
                onChange={onChangeCategory}
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
            >
                <option value={"Pizza"}>Pizza</option>
                <option value={"Pasta"}>Pasta</option>
                <option value={"Salads"}>Salads</option>
                <option selected={true} value={"Desserts"}>Desserts</option>
            </select>
        )
    }
    if(meal != null) {
        return (
            <div className="mainBody">
                <br/>
                <div className="backLine">
                    <button onClick={() => {
                        navigate("/menusEmployee");
                    }}>Go Back</button>
                </div>
                <center>
                    <h1>Update {meal.name}</h1><br/>
                    <h3>Old Image</h3>
                    <img src="" alt=""/>
                    <form onSubmit={handleSubmit}>
                        <label htmlFor="image" className="formLabelImage">Image</label><br/>
                        <input type="file" onChange={onChangeImage} className="Label"/><br/><br/><br/><br/>
                        <label htmlFor="name" className="formLabelName">Name</label><br/><br/>
                        <input type="text" onChange={onChangeName} value={name} className="Label" /><br/><br/><br/><br/>
                        <label htmlFor="username" className="formLabelDescription">Description</label><br/>
                        <input type="text" onChange={onChangeDescription} value={description} className="Label" /><br/><br/><br/><br/>
                        <label htmlFor="number" className="formLabelWeight">Weight</label><br/>
                        <input type="number" onChange={onChangeWeight} value={weight} className="Label" /><br/><br/><br/><br/>
                        <label htmlFor="number" className="formLabelPrice">Price</label><br/>
                        <input type="number" onChange={onChangePrice} value={price} className="Label" /><br/><br/><br/><br/>
                        <label htmlFor="number" className="formLabelCategory">Category</label><br/>
                        {selectedCategory}<br/>
                        <br/><br/>
                        <button type="submit" className="normalButton">Submit</button>
                    </form><br/><br/>
                </center>
            </div>
        )
   }
    else {
        return (
            <>
                No
            </>
        )
    }
}
export default UpdateMeal