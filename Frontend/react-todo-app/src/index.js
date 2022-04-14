import React from 'react';
import ReactDOM from 'react-dom';
import Index from './components/Index';
import './App.css';
import PastaMenus from "./components/PastaMenus";
import {BrowserRouter as Router} from "react-router-dom";
import Navbar from "./components/Navbar";

/*ReactDOM.render(
  <React.StrictMode>
  <Router>
   <Navbar/>
      <PastaMenus />
  </Router>

  </React.StrictMode>,
  document.getElementById('root')
);*/
ReactDOM.render(
    <React.StrictMode>
        <Index/>
    </React.StrictMode>,
    document.getElementById('root')
);

