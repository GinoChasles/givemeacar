import {Datagrid, Filter, List, SearchInput, TextField} from "react-admin";
import * as React from "react";
const PostFilter = (props) => (
    <Filter {...props}>
        <SearchInput source="q" alwaysOn />
    </Filter>
);
const DisplayClient = (props) => (
    <List {...props} title="Liste des clients" filters={<PostFilter/>}>
        <Datagrid rowClick="edit">
            <TextField source="firstName" />
            <TextField source="lastName" />
            <TextField source="mail" />
            <TextField source="password" />
            <TextField source="phone" />
            <TextField source="city" />
            <TextField source="agencyName" />
        </Datagrid>
    </List>
);

export default DisplayClient