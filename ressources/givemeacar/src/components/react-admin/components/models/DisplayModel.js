import {Datagrid, List, TextField} from "react-admin";
import * as React from "react";

const DisplayModel = (props) => (
    <List {...props} title="Modèles">
        <Datagrid rowClick="edit">
            <TextField source="name" />
            <TextField source="brand_id" />
        </Datagrid>
    </List>
);
export default DisplayModel