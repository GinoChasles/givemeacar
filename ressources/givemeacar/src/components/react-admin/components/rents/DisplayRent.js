import {Datagrid, DateField, Filter, List, ReferenceInput, SearchInput, TextField} from "react-admin";
import * as React from "react";
const PostFilter = (props) => (
    <Filter {...props}>
        <SearchInput source="q" alwaysOn />
    </Filter>
);
const DisplayRent = (props) => (
    <List {...props} title="Réservation" filters={<PostFilter/>}>
        <Datagrid rowClick="edit">
            <DateField source="start" showTime />
            <DateField source="end" showTime/>
            <TextField source="car_id" />
            <TextField source="client_id" />
        </Datagrid>
    </List>
);
export default DisplayRent