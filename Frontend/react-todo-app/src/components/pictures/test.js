import React from 'react';
import ReactDOM from 'react-dom';
import './App.css';
import PizzaMenus from "./components/PizzaMenus";
import Details from "./components/Details";

ReactDOM.render(
    <React.StrictMode>
        <Details />
    </React.StrictMode>,
    document.getElementById('root')
);