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
            <TextField source="firstName"   label="firstName" />
            <TextField source="lastName"    label="lastName" />
            <TextField source="mail"        label="mail" />
            <TextField source="password"    label="password" />
            <TextField source="phone"       label="phone" />
            <TextField source="city"        label="city" />
            <TextField source="agencyName"  label="agencyName" />
        </Datagrid>
    </List>
);

export default DisplayClient