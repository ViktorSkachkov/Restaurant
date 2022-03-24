import React from 'react';
import ReactDOM from 'react-dom';
import Index from './components/Index';
import './App.css';
import PizzaMenus from "./components/PizzaMenus";

ReactDOM.render(
  <React.StrictMode>
    <PizzaMenus />
  </React.StrictMode>,
  document.getElementById('root')
);

