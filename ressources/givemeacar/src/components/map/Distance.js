import React from "react";

export default function Distance({ onChange }) {

    return (
        <div>

                <label htmlFor="champ distance">Distance: </label>
                <input
                    type="range"
                    min="0"
                    max="100000"
                    step="200"
                    id="champDistance"
                    onChange={onChange}
                ></input>

        </div>
    );
}
