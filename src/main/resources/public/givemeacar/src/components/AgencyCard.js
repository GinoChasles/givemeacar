import React, { useState } from "react";

export default function AgencyCard({ agency }) {
  const { name, number, complement, street, city, zipcode } = agency;

  return (
    <div>
      <table>
        <tr>
          <th>
            <input type="checkbox" id="" name="check" />
            <label for="check"></label>
          </th>
          <th>name</th>
          <th>number</th>
          <th>complement</th>
          <th>street</th>
          <th>zipcode</th>
          <th>city</th>
        </tr>
        <tr>
          <td>
            <input type="checkbox" id="" name="check" />
            <label for="check"></label>
          </td>
          <td>{name}</td>
          <td>{number}</td>
          <td>{complement}</td>
          <td>{street}</td>
          <td>{zipcode}</td>
          <td>{city}</td>
        </tr>
      </table>
    </div>
  );
}
