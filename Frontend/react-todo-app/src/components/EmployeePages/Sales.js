import React, {useState} from "react";
import axios from "axios";
import Cookies from "universal-cookie";

const Sales = (loggedUser) => {
    const [orders, setOrders] = useState([]);
    const cookies = new Cookies();
    const token = cookies.get("accessToken");
    const getMeals = async () => {
        //const getMeals = [];
        var config = {
            method: "get",
            url: `http://localhost:8080/orders/Meals`,
            headers: {
                "Authorization": `Bearer ${token}`,
            },
        };

        await axios(config)
            .then(function (response) {
                setOrders(response.data);
            })
            .catch(function (error) {
                console.log(error);
            });
    }
return (
    <div className="mainBody">
        <center><br/><br/>
            <h1>Sales</h1><br/>
            <table className="salesTable">
                <tr>
                    <th>Picture</th>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Units Sold</th>
                    <th>Total Income</th>
                    <th>Date</th>
                </tr>
            </table>

        </center><br/><br/><br/>
    </div>
)
}
export default Sales;