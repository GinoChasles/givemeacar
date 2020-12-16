import {
    Datagrid,
    EmailField,
    Filter,
    List,
    ReferenceInput,
    SearchInput,
    SelectInput,
    TextField,
    TextInput
} from "react-admin";
import * as React from "react";
const PostFilter = (props) => (
    <Filter {...props}>
        <SearchInput source="q" alwaysOn />
    </Filter>
);
const DisplayAdministrators = (props) => (
    <List {...props} title="les villes de l'eeenfer" filters={<PostFilter/>}>
        <Datagrid rowClick="edit">
            <TextField source="id" />
            <TextField source="firstName" />
            <TextField source="lastName" />
            <EmailField source="mail" />
            <TextField source="phone" />
        </Datagrid>
    </List>
);

export default DisplayAdministrators