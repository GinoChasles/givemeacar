import {Datagrid, Filter, List, ReferenceInput, SearchInput, TextField, TextInput} from "react-admin";
import * as React from "react";

const PostFilter = (props) => (
    <Filter {...props}>
        <SearchInput source="q" alwaysOn />
        <ReferenceInput source="name" reference="agencies" allowEmpty>
            <SearchInput optionText="name" />
        </ReferenceInput>
        <ReferenceInput source="city_id" reference="cities" allowEmpty>
            <SearchInput optionText="name" />
        </ReferenceInput>
        <ReferenceInput source="street_id" reference="streets" allowEmpty>
            <SearchInput optionText="name" />
        </ReferenceInput>
    </Filter>
);

const DisplayAgency = (props) => (
    <List {...props} title="Agences" filters={<PostFilter/>}>
        <Datagrid rowClick="edit">
            <TextField source="id" label="id" />
            <TextField source="name" label="name" />
            <TextField source="address" label="adresse" />
        </Datagrid>
    </List>
);

export default DisplayAgency