import {Datagrid, List, TextField} from "react-admin";
import * as React from "react";

const DisplayCountry = (props) => (
    <List {...props} title="Votre adresse">
        <Datagrid rowClick="edit">
            <TextField source="name" />
        </Datagrid>
    </List>
);

export default DisplayCountry