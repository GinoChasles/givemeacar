import {Datagrid, List, TextField} from "react-admin";
import * as React from "react";

const DisplayStreet = (props) => (
    <List {...props}>
        <Datagrid rowClick="edit">
            <TextField source="city_id" />
            <TextField source="street_name_id" />
        </Datagrid>
    </List>
);
export default DisplayStreet