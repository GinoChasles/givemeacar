import {Datagrid, List, TextField} from "react-admin";
import * as React from "react";

const DisplaySuffix = (props) => (
    <List {...props} title="Suffix des adresses">
        <Datagrid rowClick="edit">
            <TextField source="name" />
        </Datagrid>
    </List>
);
export default DisplaySuffix