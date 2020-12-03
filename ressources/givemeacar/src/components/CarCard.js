import React, { useState } from "react";
// import test from "./test.json";
export default function CarCard({ car }) {
  //   let test = require("./test.json");
  //   let newjson = JSON.parse(test);
  const {
    availability,
    onRent,
    geolocalization,
    model,
    price,
    brand,
    color,
    km,
    year,
    energy,
  } = car;
  return (
    <div>
      <table>
        <tr>
          <th>
            <input type="checkbox" id="" name="check" />
            <label for="check"></label>
          </th>
          <th>Availability</th>
          <th>onRent</th>
          <th>Geolocalization</th>
          <th>price per min</th>
          <th>Model</th>
          <th>Brand</th>
          <th>color</th>
          <th>kilometers</th>
          <th>year</th>
          <th>energy</th>
        </tr>
        <tr>
          <td>
            <input type="checkbox" id="" name="check" />
            <label for="check"></label>
          </td>
          <td>{availability}</td>
          <td>{onRent}</td>
          <td>{geolocalization}</td>
          <td>{price}</td>
          <td>{model}</td>
          <td>{brand}</td>
          <td>{color}</td>
          <td>{km}</td>
          <td>{year}</td>
          <td>{energy}</td>
        </tr>
      </table>
      {/* <tr>
          <td>
            <input type="checkbox" id="" name="check" />
            <label for="check"></label>
          </td>
          <td>{newjson.availability}</td>
          <td>{newjson.car.onRent}</td>
          <td>{newjson.car.price}</td>
          <td>{newjson.car.model}</td>
          <td>{newjson.car.brand}</td>
          <td>{newjson.car.color}</td>
          <td>{newjson.car.km}</td>
          <td>{newjson.car.year}</td>
          <td>{newjson.car.energy}</td>
        </tr> */}
      {/* <div>
        <input type="checkbox" id="" name="check" />
        <label for="check"></label>
      </div>
      <div>{availability}</div>
      <div>{onRent}</div>
      <div>{geolocalization}</div>
      <div>{price}</div>
      <div>{model}</div>
      <div>{brand}</div>
      <div>{color}</div>
      <div>{km}</div>
      <div>{year}</div>
      <div>{energy}</div> */}
    </div>
  );
}
