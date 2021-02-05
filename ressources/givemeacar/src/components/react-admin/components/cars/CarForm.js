import * as React from "react";

import Model from '../form/model';
import Color from '../form/color';
import Kilometer from '../form/kilometers';
import Price from '../form/price';
import Year from '../form/year';
import Available from '../form/available';
import Rented from '../form/rented';
import EnergyType from '../form/energyType';
import EnergyMax from '../form/energyCurrent';
import EnergyCurrent from '../form/energyMax';
import Longitude from '../form/longitude';
import Latitude from '../form/latitude';


const FORM_STYLES = {
    display: 'grid',
    gridTemplateColumns: "1fr 1fr",
    gap: ".5rem",
    gridAutoColumns: "1fr"
}

export default function CarForm(props) {
    return <section style={FORM_STYLES}>
        <Model />
        
        <Year />
        
        <Color />
        
        <EnergyType />

        <EnergyCurrent />

        <EnergyMax />

        <Kilometer />

        <Price />

        <Latitude />

        <Longitude />

        <Available />

        <Rented />
    </section>
}
