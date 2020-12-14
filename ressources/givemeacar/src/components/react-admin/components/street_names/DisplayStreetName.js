import {Datagrid, List, TextField} from "react-admin";
import * as React from "react";

const DisplayStreetName = (props) => (
    <List {...props} title="Nom des rues">
        <Datagrid rowClick="edit">
            <TextField source="name" />
        </Datagrid>
    </List>
);
export default DisplayStreetName