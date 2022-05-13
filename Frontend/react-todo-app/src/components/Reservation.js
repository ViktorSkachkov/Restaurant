import React, {useEffect, useState} from "react";
import { DropdownButton,Dropdown } from 'react-bootstrap'
import button from "bootstrap/js/src/button";

function Reservation() {
    var currentdate = new Date();
    let month = currentdate.getMonth();
    let year = currentdate.getFullYear()
    let monthList = ["January", "February", "March","April","May","June","July","August","September","October","November","December"];
    let weekList = ["Sunday", "Monday", "Tuesday","Wednesday","Thursday","Friday","Saturday"];
    let monthNumber1 = currentdate.getMonth();
    let monthName1 = monthList.at(monthNumber1);
    let days1 = [];
    let monthNumber2 = monthNumber1 +1;
    if(monthNumber2 == 12) {
        monthNumber2 = 0;
    }
    let monthName2 = monthList.at(monthNumber2);
    let days2 = [];
    let date1 = new Date(year, monthNumber1, 0).getDate();
    let date2;
    if(monthNumber2 != 0) {
        date2 = new Date(year, monthNumber2, 0).getDate();
    }
    else {
        date2 = new Date(year+1, monthNumber2, 0).getDate();
    }
    console.log(date2);
   /* function increaseMonth() {
        if(monthNumber != 11) {
            monthNumber++;
        }
        else {
            monthNumber = 0;
        }
        monthName = monthList.at(monthNumber);
    }
    function decreaseMonth() {
        if (monthNumber != 0) {
            monthNumber--;
        } else {
            monthNumber = 11;
        }
        monthName = monthList.at(monthNumber);
    }*/
    let firstDate1;
    let firstDate2;
        for(let i=1; i < date1;i++) {
            let myDate1 = new Date(year, monthNumber1-1, i);
            let thisDate1 = myDate1.getDate();
            days1.push(myDate1)

            if(i ==1) {
                firstDate1 = myDate1.getDay();
            }
        }

    for(let index=1; index< date2;index++) {
        let myDate2
        if(monthNumber2 != 0) {
             myDate2 = new Date(year, monthNumber2, index);
        }
        else {
            myDate2 = new Date(year+1, monthNumber2, index);
        }
        let thisDate2 = myDate2.getDate();
        days2.push(myDate2)

        if(index ==1) {
            firstDate2 = myDate2.getDay();
        }
    }
    console.log(days2);



    /*function getDays() {
        for(let i =1; i <= date; i++) {
            let myDate = new Date(year, monthNumber, i);
            console.log(1)
            console.log(myDate.getDay)
            if(i ==1) {
                firstDate = myDate.getDay();
            }
            days.add(myDate);
            console.log(myDate);
        }
    }*/
    const [codeFirstMonth, setCodeFirstMonth] = useState(null);
    function displayDropdown1() {
        let codeBlock1;
        let list1 = [];
        days1.forEach(item => {
            if(codeFirstMonth == null) {
                let wd = item.getDay();
                codeBlock1 = (
                    <Dropdown.Item type="checkbox" as="button" className="dropdownButton">{weekList[wd]}: {item.getDate()}</Dropdown.Item>
                )
                list1.push(codeBlock1);
                setCodeFirstMonth(list1);
            }
            else {
                setCodeFirstMonth(null)
            }
        });
    }



    const [codeSecondMonth, setCodeSecondMonth] = useState(null);
    function displayDropdown2() {
        let codeBlock2;
        let list2 = [];
        days2.forEach(item => {
            if(codeSecondMonth == null) {
                let wd = item.getDay();
                codeBlock2 = (
                    <Dropdown.Item type="checkbox" as="button" className="dropdownButton">{weekList[wd]}: {item.getDate()}</Dropdown.Item>
                )
                list2.push(codeBlock2);
                setCodeSecondMonth(list2);
            }
            else {
                setCodeSecondMonth(null)
            }
        });
        console.log(codeSecondMonth);
    }
   // }
    /*return (
        <>
        <center>

            <h1 className="menuTitle">Reservation</h1><br/>
            <p className="reserveTable">Reserve a table</p>
            <br/><br/>
            <div className="dateAndPreferences">
                <p className="reserveTable">Choose a date</p>
            </div><br/>
        </center>

                <div>
                    <div className="month">
                        <ul>
                            <li className="prev" onClick={() => decreaseMonth()}>&#10094;</li>
                            <li className="next" onClick={() => increaseMonth()}>&#10095;</li>
                            <li>{monthName.toLowerCase()}<br/>
                            <span className="year">{year}</span></li>
                        </ul>
                    </div>
                    <ul className="weekdays">
                        <li>Mo</li>
                        <li>Tu</li>
                        <li>We</li>
                        <li>Th</li>
                        <li>Fr</li>
                        <li>Sa</li>
                        <li>Su</li>
                    </ul>
                    {codeBlock}
                </div><br/>
            <center>
                <div>
                    <p className="reserveTable">Preferences</p><br/>
                    <input type="textarea" className="preferencesTextarea"/>
                </div><br/>
            <button className="normalButton">Submit</button><br/><br/>
                <p>or use our phone for reservations: <i className="telephoneNumber">0700 80 222</i></p>
        </center>
            <br/><br/>
            }

        </>
    )*/

    return (
        <html>
            <center><br/><br/>
                <h1>RESERVATION</h1><br/>
                <p className="reserveTable">RESERVE A TABLE</p>
                <br/><br/>
            </center>
            <center>

                <div className="dropdown_bar">
                <button id="dropdown-item-button" onClick={displayDropdown1} className="dropdownButton">{monthName1}</button>
                {codeFirstMonth}<br/>
                    <button id="dropdown-item-button" onClick={displayDropdown2} className="dropdownButton">{monthName2}</button>
                    {codeSecondMonth}<br/>
                    </div>
                <div>
                    <p className="reserveTable">PREFERENCES</p><br/>
                    <input type="textarea" className="preferencesTextarea"/>
                </div><br/>
                <button className="normalButton">Submit</button><br/><br/>
                <p>or use our phone for reservations: <i className="telephoneNumber">0700 80 222</i></p>
            </center>
            <br/><br/><br/><br/><br/><br/>
            <script>

            </script>
        </html>
    )

}

export default Reservation
/*
<div className="dropBar">
                    <button className="click">{monthName}</button>
                    <div className="list">
                        {code}
                    </div>
                </div>
                */
/*<ul className="days">
    <li>1</li>
    <li>2</li>
    <li>3</li>
    <li>4</li>
    <li>5</li>
    <li>6</li>
    <li>7</li>
    <li>8</li>
    <li>9</li>
    <li><span className="active">10</span></li>
    <li>11</li>
    <li>12</li>
    <li>13</li>
    <li>14</li>
    <li>15</li>
    <li>16</li>
    <li>17</li>
    <li>18</li>
    <li>19</li>
    <li>20</li>
    <li>21</li>
    <li>22</li>
    <li>23</li>
    <li>24</li>
    <li>25</li>
    <li>26</li>
    <li>27</li>
    <li>28</li>
    <li>29</li>
    <li>30</li>
    <li>31</li>
</ul>*/