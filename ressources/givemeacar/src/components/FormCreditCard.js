import React, { useState } from "react";

export default function FormCreditCard({ onSubmit }) {
    const [lastname, setLastname] = useState();
    const [firstname, setFirstname] = useState();
    const [cardNumber, setCardNumber] = useState();
    const [validityEnd, setValidityEnd] = useState();

    return(
        <div>
            <form
            action=""
            method="post"
            onSubmit={(e) => {
                e.preventDefault();
                onSubmit({
                    lastname: lastname,
                    firstname: firstname,
                    cardNumber: cardNumber,
                    validityEnd: validityEnd,
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

                <label htmlFor="cardNumber" class="">Mail</label>
                <input type="text" id="" name="cardNumber" value={cardNumber} onChange={(e) =>{
                    setCardNumber(e.currentTarget.value);
                }}></input>

                <label htmlFor="validityEnd" class="">Mot de passe</label>
                <input type="date" id="" name="validityEnd" value={validityEnd} onChange={(e) =>{
                    setValidityEnd(e.currentTarget.value);
                }}></input>


                <button>Valider</button>
            </form>
        </div>
    )
}