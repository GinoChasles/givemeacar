import {Datagrid, List, TextField} from "react-admin";
import * as React from "react";

const DisplayRegion = (props) => (
    <List {...props} title="La région">
        <Datagrid rowClick="edit">
            <TextField source="name" />
        </Datagrid>
    </List>
);
export default DisplayRegion