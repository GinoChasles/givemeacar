import {Datagrid, List, TextField} from "react-admin";
import * as React from "react";

const DisplayClient = (props) => (
    <List {...props} title="Liste des clients">
        <Datagrid rowClick="edit">
            <TextField source="first_name" />
            <TextField source="last_name" />
            <TextField source="mail" />
            <TextField source="password" />
            <TextField source="phone" />
            <TextField source="address_id" />
            <TextField source="user_status_id" />
            <TextField source="bill_id" />
            <TextField source="credit_card_id" />
            <TextField source="agency_id" />
        </Datagrid>
    </List>
);

export default DisplayClient