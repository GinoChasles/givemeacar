import {Datagrid, List, TextField} from "react-admin";
import * as React from "react";

const DisplayAgency = (props) => (
    <List {...props} title="Votre adresse">
        <Datagrid rowClick="edit">
            <TextField source="name" />
            <TextField source="address_id" />
            <TextField source="manager_id" />
        </Datagrid>
    </List>
);

export default DisplayAgency