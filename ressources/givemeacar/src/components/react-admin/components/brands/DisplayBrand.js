import {Datagrid, List, TextField} from "react-admin";
import * as React from "react";

const DisplayBrand = (props) => (
    <List {...props} title="Le modèle du véhicule">
        <Datagrid rowClick="edit">
            <TextField source="name" />
        </Datagrid>
    </List>
);
export default DisplayBrand