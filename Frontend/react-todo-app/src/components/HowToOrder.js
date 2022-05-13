import React, {useEffect, useState} from "react";
import axios from "axios";


const HowToOrder = (props) =>  {
    axios.defaults.baseURL = "http://localhost:8080/";
    const [approved, setApproved] = useState([]);
    /*let number = useState(1);

    function GetUsers() {
        //axios.get(`reservations/unapprovedReservationRequests`).then(res1 => {console.log(res1.data)})
        axios.get(`reservations/approvedReservationRequests`).then(res2 => {setApproved(res2.data)})
        //axios.get(`reservations/reservationItem/${number}`).then(res3 => {console.log(res3.data)})
    }
    useEffect(() => {
        GetUsers();
    })
    console.log(approved);*/

    return (
        <div className="mainBody">
            <center><br/><br/>
                <h1>HOW TO ORDER</h1><br/><br/>
                <div className="howToOrder">
                    <b><p  className="howToOrderElement">The choice of a specific meal is extremely easy and comfortable when you can make an order in several simple steps:</p></b><br/><br/>
                    <ul>
                        <li className="howToOrderElement">1. Choose one of the main categories - Pizza, Pasta, Salads or Desserts.</li><br/><br/>
                        <li className="howToOrderElement">2. Select a specific meal from said category and see more detailed information about it or just add it to the cart.</li><br/><br/>
                        <li className="howToOrderElement">3. On the information page of the meal you can add ingredients.</li><br/><br/>
                        <li className="howToOrderElement">4. Look at the contents of your cart and finish the order.</li><br/><br/>
                    </ul>
                </div>
            </center><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
        </div>
    )
}
export default HowToOrder