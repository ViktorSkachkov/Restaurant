import React from 'react';
import ReactDOM from 'react-dom';
import Index from './components/Index';
import './App.css';
import InfoForPizzaMeal from "./components/InfoForPizzaMeal";

ReactDOM.render(
    <React.StrictMode>
        <InfoForPizzaMeal />
    </React.StrictMode>,
    document.getElementById('root')
);