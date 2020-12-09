import * as React from "react";
import {
    List,
    Datagrid,
    TextField
} from "react-admin";


const DisplayAddresses = (props) => (
    <List {...props} title="Votre adresse">
        <Datagrid rowClick="edit">
            <TextField source="number" />
            <TextField source="city_id" />
            <TextField source="street_id" />
            <TextField source="street_suffices" />
        </Datagrid>
    </List>
);

export default DisplayAddresses