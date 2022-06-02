import React, {useEffect, useState} from "react";
import { DropdownButton,Dropdown } from 'react-bootstrap'
import button from "bootstrap/js/src/button";
import Cookies from "universal-cookie";
import axios from "axios";
import {useNavigate} from "react-router-dom";

const Reservation = (loggedUser) => {
    let navigate = useNavigate();
    const [startTime, setStartTime] = useState();
    const [finishTime, setFinishTime] = useState();
    const [numberOfPeople, setNumberOfPeople] = useState(0);
    const [preferences, setPreferences] = useState("None");
    const [warning, setWarning] = useState();

    const cookies = new Cookies();
    const token = cookies.get("accessToken");

console.log(loggedUser);

    const handleSubmit = (e) => {
        e.preventDefault();
        if(numberOfPeople <= 0) {
            setWarning("The number of people should be more than 0!");
        }
        else if(numberOfPeople > 10) {
            setWarning("The number of people can't be more than 10!");
        }
        else if (finishTime < startTime || finishTime == startTime) {
            setWarning("The finish time should be after the start time!");
        }
        else {
            setWarning("")
            const config = {
                headers: { Authorization: `Bearer ${token}` }
            };
            const bodyParams = {
                "clientId": loggedUser.loggedUser.id,
                "preferences": preferences,
                "numberOfPeople": numberOfPeople,
                "start_time": startTime,
                "finish_time": finishTime,
            };
            axios.post(
                `http://localhost:8080/reservations/createReservation`,
                bodyParams,
                config
            )
                .then(function (response) {
                    navigate(`/successfullyAddedReservation`);
                })
                .catch(function (error) {
                    console.log(error);
                });
        }
    }
    const onChangeNumberOfPeople = event => {
        setNumberOfPeople(event.target.value);
    }
    const onChangeStartTime = event => {
        setStartTime(event.target.value);
    }
    const onChangeFinishTime = event => {
        setFinishTime(event.target.value);
    }
    const onChangePreferences = event => {
        setPreferences(event.target.value);
    }
    return (
        <div className="mainBody">
            <center><br/><br/>
                <h1>MAKE RESERVATION</h1><br/><br/>
                <form onSubmit={handleSubmit}>
                    <label htmlFor="numberOfPeople" className="formLabelNumberOfPeople">Number Of People</label><br/><br/>
                    <input onChange={onChangeNumberOfPeople} type="number" className="Label"/><br/><br/>
                    <label htmlFor="startTime" className="formLabelStartTime">Start Time</label><br/><br/>
                    <input onChange={onChangeStartTime} type="datetime-local" className="Label"/><br/><br/>
                    <label htmlFor="finishTime" className="formLabelFinishTime">Finish Time</label><br/><br/>
                    <input onChange={onChangeFinishTime} type="datetime-local" className="Label"/><br/><br/>
                    <label for="preferences" className="formLabelPreferences">Preferences</label><br/><br/>
                    <select
                        className="Label"
                        onChange={onChangePreferences}
                    >
                        <option value={"None"}>None</option>
                        <option value={"Inside"}>Inside</option>
                        <option value={"Outside"}>Outside</option>
                    </select>
                <br/><br/><br/><br/>
                <button className="normalButton">Submit</button>
                </form><br/>
                <p className="WarningMessage">{warning}</p>
            </center>
            <br/><br/><br/><br/>
        </div>
    )

}

export default Reservation