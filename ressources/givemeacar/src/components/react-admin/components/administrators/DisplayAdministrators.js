import {Datagrid, EmailField, List, TextField} from "react-admin";
import * as React from "react";

const DisplayAdministrators = (props) => (
    <List {...props} title="les villes de l'eeenfer">
        <Datagrid rowClick="edit">
            <TextField source="id" />
            <TextField source="firstName" />
            <TextField source="lastName" />
            <EmailField source="mail" />
            <TextField source="phone" />
        </Datagrid>
    </List>
);

export default DisplayAdministrators