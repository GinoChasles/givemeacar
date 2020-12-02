import React from "react";

export default function ManagerCard({ manager }) {
  const { lastName, firstName, mail, phone, agency } = manager;
  return (
    <div>
      <table>
        <tr>
          <th>
            <input type="checkbox" id="" name="check" />
            <label for="check"></label>
          </th>
          <th>Agency</th>
          <th>lastName</th>
          <th>firstName</th>
          <th>mail</th>
          <th>phone</th>
        </tr>

        <tr>
          <td>
            <input type="checkbox" id="" name="check" />
            <label for="check"></label>
          </td>
          <td>{agency}</td>
          <td>{lastName}</td>
          <td>{firstName}</td>
          <td>{mail}</td>
          <td>{phone}</td>
        </tr>
      </table>
    </div>
  );
}
