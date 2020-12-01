import React, { useState } from "react";

export default function FormAgency({ onSubmit }) {
  const [number, setNumber] = useState();
  const [complement, setComplement] = useState();
  const [street, setStreet] = useState();
  const [city, setCity] = useState();
  const [zipcode, setZipcode] = useState();
  const [name, setName] = useState();

  return (
    <div>
      <form
        onSubmit={(e) => {
          e.preventDefault();
          fetch("http://localhost:8080/api/agencies/", {
            method: "POST",
            body: JSON.stringify({
              name: name,
            number: number,
            complement: complement,
            street: street,
            city: city,
            zipcode: zipcode,
            }),
          })
            .then(function (response) {
              if (response.ok) {
                console.log(response.status);
              }
            })
            .then(function (json) {
              console.log(json);
            });
          onSubmit({
            name: name,
            number: number,
            complement: complement,
            street: street,
            city: city,
            zipcode: zipcode,
          });
        }}
      >
        <label htmlFor="number" class="">
          Numéro de rue
        </label>
        <input
          type="number"
          id=""
          name="number"
          value={number}
          onChange={(e) => {
            setNumber(e.currentTarget.value);
          }}
        ></input>

        <label htmlFor="complement" class="">
          complément de rue
        </label>
        <input
          type="text"
          id=""
          name="complement"
          value={complement}
          onChange={(e) => {
            setComplement(e.currentTarget.value);
          }}
        ></input>

        <label htmlFor="street" class="">
          rue
        </label>
        <input
          type="text"
          id=""
          name="street"
          value={street}
          onChange={(e) => {
            setStreet(e.currentTarget.value);
          }}
        ></input>

        <label htmlFor="city" class="">
          ville
        </label>
        <input
          type="text"
          id=""
          name="city"
          value={city}
          onChange={(e) => {
            setCity(e.currentTarget.value);
          }}
        ></input>

        <label htmlFor="zipcode" class="">
          code postal
        </label>
        <input
          type="text"
          id=""
          name="zipcode"
          value={zipcode}
          onChange={(e) => {
            setZipcode(e.currentTarget.value);
          }}
        ></input>

        <label htmlFor="name" class="">
          Nom
        </label>
        <input
          type="text"
          id=""
          name="name"
          value={name}
          onChange={(e) => {
            setName(e.currentTarget.value);
          }}
        ></input>

        <button>Créer agence</button>
      </form>
    </div>
  );
}
