import React from 'react';
import ReactDOM from 'react-dom';
import Index from './components/Index';
import './App.css';
import PastaMenus from "./components/PastaMenus";
import {BrowserRouter as Router} from "react-router-dom";
import Navbar from "./components/Navbar";
import Navigation from "./components/Navigation";
import Footer from "./components/Footer";

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
        <Navigation/>
        <Footer/>
    </React.StrictMode>,
    document.getElementById('root')
);

