import {Datagrid, List, TextField} from "react-admin";
import * as React from "react";

const DisplayStatus = (props) => (
    <List {...props} title="Privilèges">
        <Datagrid rowClick="edit">
            <TextField source="name" />
        </Datagrid>
    </List>
);
export default DisplayStatus