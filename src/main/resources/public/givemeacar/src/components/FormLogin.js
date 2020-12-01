import React, { useState } from "react";

export default function FormLogin({ onSubmit }) {
    const [login, setLogin] = useState();
    const [password, setPassword] = useState();


    return (
        <div>
            <form
            action=""
            method="post"
            onSubmit={(e) => {
                e.preventDefault();
                onSubmit({
                    login: login,
                    password: password,
                });
            }}>
                <label htmlFor="login" class="">Identifiant</label>
                <input
                type="date"
                id=""
                name="login"
                value={login}
                onChange={(e) => {
                    setLogin(e.currentTarget.value);
                }}
                ></input>
                <label htmlFor="password" class="">Mot de passe</label>
                <input type="password" id="" name="passeword" value={password} onChange={(e) =>{
                    setPassword(e.currentTarget.value);
                }}></input>

            <button>S'indetifier</button>
            </form>
        </div>
    )
}

