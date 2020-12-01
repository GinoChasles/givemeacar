import React, { useState } from "react";

export default function FormUnsubscribe({ onSubmit }) {
    const [unsubscribe, setUnsubscribe] = useState();



    return (
        <div>
            <form
            action=""
            method="post"
            onSubmit={(e) => {
                e.preventDefault();
                onSubmit({
                    unsubscribe: unsubscribe,
                });
            }}>
                <label htmlFor="unsubscribe" class="">Voulez vous vraiment vous désinscrire ?</label>
                <input
                type="checkbox"
                id=""
                name="unsubscribe"
                value={unsubscribe}
                onChange={(e) => {
                    setUnsubscribe(e.currentTarget.value);
                }}
                >oui</input>

            <button>Valider</button>
            </form>
        </div>
    )
}

