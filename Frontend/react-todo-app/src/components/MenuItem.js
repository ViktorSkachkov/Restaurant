import React, {useState, useEffect} from "react"

const MenuItem = props => {
    let number = 0;
    if(props != null) {
        return (
            <>
                <div className="menuItem">
                    <img src={props.image} alt=""/>
                    <br/>
                    <h3>{props.name}</h3>
                    <br/>
                    <p>{props.description}</p>
                    <br/>
                    <div className="weightAndPrice">
                        <p>
                            {props.weight}
                        </p>
                        <p>
                            {props.price} €
                        </p>
                    </div>
                    <br/>
                    <br/>
                    <div className="menuButtons">
                        <button key={props.id}><a href="">Details ></a></button>
                        <button key={props.id}><a href="">Add to cart ></a></button>
                    </div>
                </div>
            </>
        )
    }
    else {
        return (
            <p>{++number}</p>
        )
   }
}
export default MenuItem