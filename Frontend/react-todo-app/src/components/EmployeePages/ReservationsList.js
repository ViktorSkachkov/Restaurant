import React, {useEffect, useState} from "react";
import Cookies from "universal-cookie";
import axios from "axios";
import {useNavigate} from "react-router-dom";

const ReservationsList = (loggedUser) => {
    let navigate = useNavigate();
    //const [reservations, setReservations] = useState([]);
    //const [reservations2, setReservations2] = useState([]);
    const [allReservations, setAllReservations] = useState([]);
    const [message, setMessage] = useState("");

    let list = [];
    let list2 = [];
    let reservationItem;

    const cookies = new Cookies();
    const token = cookies.get("accessToken");
    useEffect(() => {
        /*getUnassignedReservations();
        getAssignedReservations();*/
        getAllReservations();
    },[loggedUser.loggedUser])
    /*function getUnassignedReservations() {
        var config = {
            method: "get",
            url: `http://localhost:8080/reservations/unapprovedReservationRequests`,
            headers: {
                "Authorization": `Bearer ${token}`,
            },
        };

        axios(config)
            .then(function (response) {
                setReservations(response.data);
            })
            .catch(function (error) {
                console.log(error);
            });
    }
    function getAssignedReservations() {
        var config = {
            method: "get",
            url: `http://localhost:8080/reservations/approvedReservationRequests`,
            headers: {
                "Authorization": `Bearer ${token}`,
            },
        };

        axios(config)
            .then(function (response) {
                setReservations2(response.data);
            })
            .catch(function (error) {
                console.log(error);
            });
    }*/
    function getAllReservations() {
        var config = {
            method: "get",
            url: `http://localhost:8080/reservations/all`,
            headers: {
                "Authorization": `Bearer ${token}`,
            },
        };

        axios(config)
            .then(function (response) {
                setAllReservations(response.data);
            })
            .catch(function (error) {
                console.log(error);
            });
    }

    function rejectReservation(id) {
        var config = {
            method: "get",
            url: `http://localhost:8080/reservations/deleteReservation/${id}`,
            headers: {
                "Authorization": `Bearer ${token}`,
            },
        };

        axios(config)
            .then(function (response) {
                navigate(`/successfullyDeletedReservation`);
            })
            .catch(function (error) {
                console.log(error);
            });
    }
    for(let i = 0; i < allReservations.length; i++) {
        if(allReservations.at(i).approved == "false") {
            reservationItem = (
                <div className="reservationItem">
                    <div className="reservationText">
                        <p>Reservation Number: {allReservations.at(i).id} <br/>
                            Phone: {allReservations.at(i).user.phone} <br/>
                            From: {allReservations.at(i).formatted_start_time}<br/>
                            Until: {allReservations.at(i).formatted_finish_time}<br/>
                            Number of People: {allReservations.at(i).numberOfPeople} <br/>
                            Preferences: {allReservations.at(i).preferences}</p> <br/>
                    </div>
                    <div>
                        <div>
                            <button className="reservationItemButton" onClick={() => {
                                navigate(`/assignTables/${allReservations.at(i).id}`, {

                                });
                            }}>
                                Assign Table
                            </button>
                            <button className="reservationItemButton" onClick={() => rejectReservation(allReservations.at(i).id) }>
                                Reject
                            </button>
                        </div>
                    </div>
                </div>
            )
            list.push(reservationItem);
        }
        else if(allReservations.at(i).approved == "true") {
            reservationItem = (
                <div className="reservationItem">
                    <div className="reservationText">
                        <p>Reservation Number: {allReservations.at(i).id} <br/>
                            Phone: {allReservations.at(i).user.phone} <br/>
                            From: {allReservations.at(i).formatted_start_time}<br/>
                            Until: {allReservations.at(i).formatted_finish_time}<br/>
                            Number of People: {allReservations.at(i).numberOfPeople} <br/>
                            Preferences: {allReservations.at(i).preferences}</p> <br/>
                    </div>
                    <div>
                        <div>
                            <button className="reservationItemButton2" onClick={() => {
                                navigate(`/assignTables/${allReservations.at(i).id}`, {

                                });
                            }}>
                                Reassign
                            </button>
                            <button className="reservationItemButton" onClick={() => rejectReservation(allReservations.at(i).id) }>
                                Reject
                            </button>
                        </div>
                    </div>
                </div>
            )
            list2.push(reservationItem);
        }
    }
   /* for(let i = 0; i < reservations.length; i++) {
        reservationItem = (
            <div className="reservationItem">
                <div className="reservationText">
                    <p>Reservation Number: {reservations.at(i).id} <br/>
                    Phone: {reservations.at(i).user.phone} <br/>
                        From: {reservations2.at(i).formatted_start_time}<br/>
                        Until: {reservations2.at(i).formatted_finish_time}<br/>
                    Number of People: {reservations.at(i).numberOfPeople} <br/>
                    Preferences: {reservations.at(i).preferences}</p> <br/>
                </div>
                <div>
                    <div>
                    <button className="reservationItemButton" onClick={() => {
                        navigate(`/assignTables/${reservations.at(i).id}`, {

                        });
                    }}>
                        Assign Table
                    </button>
                    <button className="reservationItemButton" onClick={() => rejectReservation(reservations.at(i).id) }>
                        Reject
                    </button>
                    </div>
                </div>
            </div>
        )
        list.push(reservationItem);
    }

    for(let i = 0; i < reservations2.length; i++) {
        reservationItem = (
            <div className="reservationItem">
                <div className="reservationText">
                    <p>Reservation Number: {reservations2.at(i).id} <br/>
                        Phone: {reservations2.at(i).user.phone} <br/>
                        From: {reservations2.at(i).formatted_start_time}<br/>
                        Until: {reservations2.at(i).formatted_finish_time}<br/>
                        Number of People: {reservations2.at(i).numberOfPeople} <br/>
                        Preferences: {reservations2.at(i).preferences}</p> <br/>
                </div>
                <div>
                    <div>
                        <button className="reservationItemButton2" onClick={() => {
                            navigate(`/assignTables/${reservations2.at(i).id}`, {

                            });
                        }}>
                            Reassign
                        </button>
                        <button className="reservationItemButton" onClick={() => rejectReservation(reservations2.at(i).id) }>
                            Reject
                        </button>
                    </div>
                </div>
            </div>
        )
        list2.push(reservationItem);
    }*/
        return (
            <>
                <h3>Unassigned Reservations</h3>
                {list}
                <h3>Assigned Reservations</h3>
                {list2}
            </>
        )
}
export default ReservationsList