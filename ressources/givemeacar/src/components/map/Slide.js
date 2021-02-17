
import React from "react";

export default function Slide({ onChange }) {

    return (
        <div>

            <label>Distance: </label>
            <input
                type="range"
                min="0"
                max="15000"
                step="200"
                id="champDistance"
                onChange={onChange}
            ></input>

        </div>
    );
}