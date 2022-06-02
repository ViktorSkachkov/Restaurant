import React, {useEffect, useState} from "react";
import {useNavigate, useParams} from "react-router-dom";
import Cookies from "universal-cookie";
import axios from "axios";


const AssignTables = (loggedUser) => {
    let navigate = useNavigate();
    let params = useParams();
    const [tables, setTables] = useState([]);
    const [reservation, setReservation] = useState();
    const [assignedTable, setAssignedTable] = useState();
    let list = [];
    let tableItem;

    const cookies = new Cookies();
    const token = cookies.get("accessToken");

    useEffect(() => {
        getReservation();
        getTables();
        getAssignedTable();
    }, [loggedUser.loggedUser])
    function getAssignedTable() {
        var config = {
            method: "get",
            url: `http://localhost:8080/reservations/relations/${params.id}`,
            headers: {
                "Authorization": `Bearer ${token}`,
            },
        };

        axios(config)
            .then(function (response) {
                setAssignedTable(response.data);
            })
            .catch(function (error) {
                console.log(error);
            });
    }
    function getReservation() {
        var config = {
            method: "get",
            url: `http://localhost:8080/reservations/reservationItem/${params.id}`,
            headers: {
                "Authorization": `Bearer ${token}`,
            },
        };

        axios(config)
            .then(function (response) {
                setReservation(response.data);
            })
            .catch(function (error) {
                console.log(error);
            });
    }
function assignTable(tableId) {
    console.log(tableId);
    var config = {
        method: "get",
        url: `http://localhost:8080/reservations/assignTable/${tableId}/${params.id}`,
        headers: {
            "Authorization": `Bearer ${token}`,
        },
    };

    axios(config)
        .then(function (response) {
            navigate(`/successfullyAssignedTable/${params.id}`);
        })
        .catch(function (error) {
            console.log(error);
        });
}
    function getTables() {
        var config = {
            method: "get",
            url: `http://localhost:8080/reservations/tables/${params.id}`,
            headers: {
                "Authorization": `Bearer ${token}`,
            },
        };

        axios(config)
            .then(function (response) {
                setTables(response.data);
            })
            .catch(function (error) {
                console.log(error);
            });
    }

    for(let i = 0; i < tables.length; i++) {
        if(tables.at(i).seats >= reservation.numberOfPeople) {
            tableItem = (
                <div className="tableItem">
                    <div className="tableSeatsAndLocation">
                        <p>
                            Number: {tables.at(i).id} <br/><br/>
                            Seats: {tables.at(i).seats} <br/><br/>
                            Location: {tables.at(i).location}
                        </p>
                    </div>
                    <div className="tableButton">
                        <div>
                            <button onClick={() => assignTable(tables.at(i).id)} className="assignButton">
                                Assign
                            </button>
                        </div>
                    </div>
                </div>
            );
            list.push(tableItem);
        }
    }
    if(reservation != null && assignedTable != null) {
        let assignedTableItem = (
            <div className="tableItem">
                <div className="tableSeatsAndLocation">
                    <p>
                        Number: {assignedTable.id}  <br/><br/>
                        Seats: {assignedTable.seats}   <br/><br/>
                        Location: {assignedTable.location}
                    </p>
                </div>
                <div className="tableButton">
                    <div>
                        <p className="assignedText">
                            Assigned
                        </p>
                    </div>
                </div>
            </div>
        )
    return (
        <div className="mainBody">
            <br/>
            <div className="backLine">
                <button onClick={() => {
                    navigate("/reservationsEmployee");
                }}>Go Back</button>
            </div>
            <center>
                <h1>Assign Table for {reservation.numberOfPeople} people</h1><br/>
                <h3>Assigned Table</h3><br/>
                <div className="tableList">
                    {assignedTableItem}
                </div>
                <h3>Unassigned Tables</h3><br/>
                <div className="tableList">
                    {list}
                </div>
            </center>
        </div>
    )
}
    else if(reservation != null && assignedTable == null) {
        return (
            <div className="mainBody">
                <br/>
                <div className="backLine">
                    <button onClick={() => {
                        navigate("/reservationsEmployee");
                    }}>Go Back</button>
                </div>
                <center>
                    <h1>Assign Table for {reservation.numberOfPeople} people</h1><br/>
                    <h3>Unassigned Tables</h3><br/>
                    <div className="tableList">
                        {list}
                    </div>
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
export default AssignTables