import React, { useState } from "react";

export default function FicheAdresse({ adresse }) {
  const { number, street, city } = adresse;
  const { name, zipcode } = city;

  return (
    <div
      style={{
        display: "flex",
        flexDirection: "row",
        gap: "1rem",
      }}
    >
      <div>zipcode</div>
      <div>{zipcode}</div>

      <div>number</div>
      <div>{number}</div>

      <div>street</div>
      <div>{street}</div>

      <div>city</div>
      <div>{city}</div>
    </div>
  );
}
