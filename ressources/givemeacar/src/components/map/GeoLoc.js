import { Marker, Popup, useMapEvents, Circle } from "react-leaflet";
import React, { useState } from "react";

export default function GeoLoc({props}) {

    const [position, setPosition] = useState(null);
    const map = useMapEvents({
        click() {
            map.locate();
        },
        locationfound(e) {
            setPosition(e.latlng);
            // map.flyTo(e.latlng, map.getZoom()); //permet de remettre le focus sur le point
        },
    });
    return position === null ? null : (
        <div>
            <Marker position={position} >
                <Popup>Je sais que tu es là !</Popup>
            </Marker>
            <Circle center={position} radius={props} />
        </div>
    );
}