import {Datagrid, List, TextField} from "react-admin";
import * as React from "react";

const DisplayColor = (props) => (
    <List {...props} title="Liste de couleurs create color">
        <Datagrid rowClick="edit">
            <TextField source="name" />
        </Datagrid>
    </List>
);
export default DisplayColor