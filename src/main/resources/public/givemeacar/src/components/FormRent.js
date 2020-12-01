import React, { useState } from "react";

export default function FormRent({ onSubmit }) {
  const [startDate, setStartDate] = useState();
  const [endDate, setEndDate] = useState();


  return (
    <div>
      <form
        action=""
        method="post"
        onSubmit={(e) => {
          e.preventDefault();
          onSubmit({
            startDate: startDate,
            endDate: endDate,
          });
        }}
      >
        <label htmlFor="startDate" class="">
          Début de la location
        </label>
        <input
          type="date"
          id=""
          name="startDate"
          value={startDate}
          onChange={(e) => {
            setStartDate(e.currentTarget.value);
          }}
        ></input>

        <label htmlFor="endDate" class="">
          Fin de la location
        </label>
        <input
          type="date"
          id=""
          name="endDate"
          value={endDate}
          onChange={(e) => {
            setEndDate(e.currentTarget.value);
          }}
        ></input>

        <button>Louer</button>
      </form>
    </div>
  );
}
