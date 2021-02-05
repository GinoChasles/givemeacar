import * as React from "react";
import { SimpleForm, SaveButton, Toolbar } from "react-admin";

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

const CarToolbar = props => (
    <Toolbar {...props}>
        <SaveButton submitOnEnter transform={(data) => {
            data.available = data.available === true ? 1 : 0;
            data.rented = data.rented === true ? 1 : 0;
            console.log(data)
            return data;
        }} />
    </Toolbar>
);

export default function CarForm() {
    return <SimpleForm toolbar={<CarToolbar />}>

        <Kilometer />

        <Price />

        <Year />

        <Available />

        <Rented />

        <Model />

        <Color />

        <EnergyMax />

        <EnergyCurrent />

        <EnergyType />

        <Latitude />

        <Longitude />

    </SimpleForm>
}
