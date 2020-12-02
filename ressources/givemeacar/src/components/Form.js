import React, { useState } from "react";

export default function Form({ onSubmit }) {
  const [number, setNumber] = useState();
  const [complement, setComplement] = useState();
  const [street, setStreet] = useState();
  const [city, setCity] = useState();
  const [zipcode, setZipcode] = useState();
  const [newsletter, setNewsletter] = useState();

  return (
    <div>
      <form
        action=""
        method="post"
        style={{
          display: "grid",
          gridTemplateColumns: "1fr 1fr",
          gap: "1rem",
        }}
        onSubmit={(e) => {
          e.preventDefault();
          onSubmit({
            number: number,
            complement: complement,
            street: street,
            city: city,
            zipcode: zipcode,
            newsletter: newsletter,
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

        <button>Click me!</button>
      </form>
    </div>
  );
}
