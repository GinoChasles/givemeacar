import {
    MapContainer,
    TileLayer
} from "react-leaflet";
import React, { useState } from "react";
import Localisation from "./Localisation";
import Distance from "./Distance";
import 'leaflet/dist/leaflet.css';

export default function Map() {

    const [radius, setRadius] = useState(2000);
    const onchange = (event) => {
        setRadius(event.currentTarget.value);
    };





    return (
        <>

            <Distance onChange={onchange} />
            <MapContainer
                center={[47.2239586, -1.5408058]}
                zoom={7}
                scrollWheelZoom={false}
                style={{ height: "50vh", width: "50%", margin: "auto" }}
            >
                <Localisation props={radius} />
                {/* coordonnée nantes*/}
                <TileLayer
                    attribution='&copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors'
                    url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
                />
                {/* on affiche un marqueur pour chaque agency dans notre fichier json */}
                {/*    {agency.agencies.map((el) => (
                    <>
                        <Marker key={el.id} position={[el.coord[0], el.coord[1]]}>
                            <Popup>Agence de {el.nom}</Popup>
                        </Marker>
                    </>
                ))}*/}
            </MapContainer>
        </>
    );
}