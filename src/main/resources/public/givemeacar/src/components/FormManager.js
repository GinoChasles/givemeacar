import React, { useState } from "react";

export default function FormManager({ onSubmit }) {
  const [lastName, setlastName] = useState();
  const [firstName, setfirstName] = useState();
  const [mail, setMail] = useState();
  const [password, setPassword] = useState();
  const [phone, setPhone] = useState();

  return (
    <div>
      <form
        onSubmit={(e) => {
          e.preventDefault();
          fetch("http://localhost:8080/api/managers", {
            method: "POST",
            body: JSON.stringify({
              lastName: lastName,
              firstName: firstName,
              mail: mail,
              password: password,
              phone: phone,
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
            lastName: lastName,
            firstName: firstName,
            mail: mail,
            password: password,
            phone: phone,
          });
        }}
      >
        <label htmlFor="lastName" class="">
          Nom
        </label>
        <input
          type="text"
          id=""
          name="lastName"
          value={lastName}
          onChange={(e) => {
            setlastName(e.currentTarget.value);
          }}
        ></input>

        <label htmlFor="firstName" class="">
          Prénom
        </label>
        <input
          type="text"
          id=""
          name="firstName"
          value={firstName}
          onChange={(e) => {
            setfirstName(e.currentTarget.value);
          }}
        ></input>

        <label htmlFor="mail" class="">
          Mail
        </label>
        <input
          type="text"
          id=""
          name="mail"
          value={mail}
          onChange={(e) => {
            setMail(e.currentTarget.value);
          }}
        ></input>

        <label htmlFor="password" class="">
          Mot de passe
        </label>
        <input
          type="password"
          id=""
          name="password"
          value={password}
          onChange={(e) => {
            setPassword(e.currentTarget.value);
          }}
        ></input>

        <label htmlFor="phone" class="">
          numéro de téléphone
        </label>
        <input
          type="number"
          id=""
          name="phone"
          value={phone}
          onChange={(e) => {
            setPhone(e.currentTarget.value);
          }}
        ></input>

        <button type="submit">Creer un manager</button>
      </form>
    </div>
  );
}
