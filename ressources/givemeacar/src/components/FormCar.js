import React, { useState } from "react";

export default function FormCar({ onSubmit }) {
  const [color, setColor] = useState();
  const [brand, setBrand] = useState();
  const [model, setModel] = useState();
  const [km, setKm] = useState();
  const [price, setPrice] = useState();
  const [year, setYear] = useState();
  const [availability, setAvailability] = useState();
  const [onRent, setOnRent] = useState();
  const [energy, setEnergy] = useState();

  return (
    <div>
      <form
      onSubmit={(e) => {
          e.preventDefault();
          fetch("http://localhost:8080/api/cars/", {
            method: "POST",
            body: JSON.stringify({
              color: color,
              brand: brand,
              model: model,
              km: km,
              price: price,
              year: year,
              availability: availability,
              onRent: onRent,
              energy: energy,
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
            color: color,
            brand: brand,
            model: model,
            km: km,
            price: price,
            year: year,
            availability: availability,
            onRent: onRent,
            energy: energy,
          });
        }}
        style={{
          display: "grid",
          gridTemplateColumns: "1fr 1fr",
          gap: "1rem",
        }}
      >
        <label htmlFor="color" class="">
          Couleur
        </label>
        <input
          type="text"
          id=""
          name="color"
          value={color}
          onChange={(e) => {
            setColor(e.currentTarget.value);
          }}
        ></input>

        <label htmlFor="brand" class="">
          Marque
        </label>
        <input
          type="text"
          id=""
          name="brand"
          value={brand}
          onChange={(e) => {
            setBrand(e.currentTarget.value);
          }}
        ></input>

        <label htmlFor="model" class="">
          Modèle
        </label>
        <input
          type="text"
          id=""
          name="model"
          value={model}
          onChange={(e) => {
            setModel(e.currentTarget.value);
          }}
        ></input>

        <label htmlFor="km" class="">
          kilometrage
        </label>
        <input
          type="number"
          id=""
          name="km"
          value={km}
          onChange={(e) => {
            setKm(e.currentTarget.value);
          }}
        ></input>

        <label htmlFor="price" class="">
          Price per minute
        </label>
        <input
          type="number"
          id=""
          name="price"
          value={price}
          onChange={(e) => {
            setPrice(e.currentTarget.value);
          }}
        ></input>

        <label htmlFor="year" class="">
          Année
        </label>
        <input
          type="number"
          id=""
          name="year"
          value={year}
          onChange={(e) => {
            setYear(e.currentTarget.value);
          }}
        ></input>

        <label htmlFor="energy" class="">
          Carburant
        </label>
        <input
          type="text"
          id=""
          name="energy"
          value={energy}
          onChange={(e) => {
            setEnergy(e.currentTarget.value);
          }}
        ></input>

        <label htmlFor="availability" class="">
          Disponible
        </label>
        <select
          name="availability"
          value={availability}
          onChange={(e) => {
            setAvailability(e.currentTarget.value);
          }}
        >
          <option value="yes" selected>
            Oui
          </option>
          <option value="no">Non</option>
        </select>

        <label htmlFor="onRent" class="">
          En location
        </label>
        <select
          name="onRent"
          value={onRent}
          onChange={(e) => {
            setOnRent(e.currentTarget.value);
          }}
        >
          <option value="yes" selected>
            Oui
          </option>
          <option value="no">Non</option>
        </select>

        <button>Envoyer</button>
      </form>
    </div>
  );
}
