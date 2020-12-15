import {Datagrid, Filter, List, TextField, TextInput, SearchInput} from "react-admin";
import * as React from "react";
const PostFilter = (props) => (
    <Filter {...props}>
        <SearchInput source="q" alwaysOn />
    </Filter>
);
const DisplayCountry = (props) => (
    <List {...props} title="Votre adresse" filters={<PostFilter/>}>
        <Datagrid rowClick="edit">
            <TextField source="name" />
        </Datagrid>
    </List>
);

export default DisplayCountry