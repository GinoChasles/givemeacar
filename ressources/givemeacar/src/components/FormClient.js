import React, { useState } from "react";

export default function FormClient({ onSubmit }) {
    const [lastname, setLastname] = useState();
    const [firstname, setFirstname] = useState();
    const [mail, setMail] = useState();
    const [password, setPassword] = useState();
    const [phonenumber, setPhonenumber] = useState();

    return(
        <div>
            <form
            onSubmit={(e) => {
                e.preventDefault();
                fetch("http://localhost:8080/api/clients/", {
            method: "POST",
            body: JSON.stringify({
                lastname: lastname,
                firstname: firstname,
                mail: mail,
                password: password,
                phonenumber: phonenumber,
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
                    lastname: lastname,
                    firstname: firstname,
                    mail: mail,
                    password: password,
                    phonenumber: phonenumber,
                });
            }}
            >
                <label htmlFor="lastname" class="">Nom</label>
                <input type="text" id="" name="lastname" value={lastname} onChange={(e) =>{
                    setLastname(e.currentTarget.value);
                }}></input>

                <label htmlFor="firstname" class="">Prénom</label>
                <input type="text" id="" name="firstname" value={firstname} onChange={(e) =>{
                    setFirstname(e.currentTarget.value);
                }}></input>

                <label htmlFor="mail" class="">Mail</label>
                <input type="text" id="" name="mail" value={mail} onChange={(e) =>{
                    setMail(e.currentTarget.value);
                }}></input>

                <label htmlFor="password" class="">Mot de passe</label>
                <input type="number" id="" name="passeword" value={password} onChange={(e) =>{
                    setPassword(e.currentTarget.value);
                }}></input>

                <label htmlFor="phonenumber" class="">Numéro de téléphone</label>
                <input type="number" id="" name="phonenumber" value={phonenumber} onChange={(e) =>{
                    setPhonenumber(e.currentTarget.value);
                }}></input>

                <button>Creer un compte</button>
            </form>
        </div>
    )
}