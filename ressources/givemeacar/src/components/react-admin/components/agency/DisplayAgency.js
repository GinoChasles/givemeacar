import {Datagrid, Filter, List, ReferenceInput, SearchInput, TextField, TextInput} from "react-admin";
import * as React from "react";

const PostFilter = (props) => (
    <Filter {...props}>
        <TextInput label="Search" source="q" alwaysOn />
        <ReferenceInput source="manager_id" reference="managers" allowEmpty>
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
    <List {...props} title="Votre adresse" filters={<PostFilter/>}>
        <Datagrid rowClick="edit">
            <TextField source="name" />
            <TextField source="address_id" />
            <TextField source="manager_id" />
        </Datagrid>
    </List>
);

export default DisplayAgency