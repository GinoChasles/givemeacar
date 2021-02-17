import {
    MapContainer,
    TileLayer
} from "react-leaflet";
import React, { useState } from "react";
import GeoLoc from "./GeoLoc";
import Slide from "./Slide";
import L from 'leaflet';
import 'leaflet/dist/leaflet.css';
import icon from 'leaflet/dist/images/marker-icon.png';
import iconShadow from 'leaflet/dist/images/marker-shadow.png';

let DefaultIcon = L.icon({
    iconUrl: icon,
    shadowUrl: iconShadow,
    iconSize: [24,36],
    iconAnchor: [12,36]
});

L.Marker.prototype.options.icon = DefaultIcon;

export default function Map() {

    const [radius, setRadius] = useState(2000);
    const onchange = (event) => {
        setRadius(event.currentTarget.value);
    };





    return (
        <>

            <Slide onChange={onchange} />
            <MapContainer
                center={[47.2239586, -1.5408058]}
                zoom={7}
                scrollWheelZoom={false}
                style={{ height: "50vh", width: "50%", margin: "auto" }}
            >
                <GeoLoc props={radius} />
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