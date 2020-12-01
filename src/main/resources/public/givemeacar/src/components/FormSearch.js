import React, { useState } from "react";

export default function FormSearch({ onSubmit }) {
    const [search, setSearch] = useState();



    return (
        <div>
            <form
            action=""
            method="post"
            onSubmit={(e) => {
                e.preventDefault();
                onSubmit({
                    search: search,
                });
            }}>
                <label htmlFor="search" class="">Recherche</label>
                <input
                type="text"
                id=""
                name="search"
                value={search}
                onChange={(e) => {
                    setSearch(e.currentTarget.value);
                }}
                ></input>

            <button>Valider</button>
            </form>
        </div>
    )
}

