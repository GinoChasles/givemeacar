import {Datagrid, DateField, List, TextField} from "react-admin";
import * as React from "react";

const DisplayRent = (props) => (
    <List {...props} title="Réservation">
        <Datagrid rowClick="edit">
            <DateField source="start" showTime />
            <DateField source="end" showTime/>
            <TextField source="car_id" />
            <TextField source="client_id" />
        </Datagrid>
    </List>
);
export default DisplayRent