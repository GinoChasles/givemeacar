import * as React from "react";
import {
    List,
    Datagrid,
    TextField, Filter, TextInput, ReferenceInput, SelectInput, AutocompleteInput, SearchInput
} from "react-admin";
const PostFilter = (props) => (
    <Filter {...props}>
        <SearchInput source="q" alwaysOn />
        <ReferenceInput source="city_id" reference="cities" allowEmpty>
            <SearchInput optionText="name" />
        </ReferenceInput>
        <ReferenceInput source="street_id" reference="streets" allowEmpty>
            <SearchInput />
        </ReferenceInput>
    </Filter>
);

const DisplayAddresses = (props) => (
    <List {...props} title="Votre adresse" filters={<PostFilter/>}>
        <Datagrid rowClick="edit" >
            <TextField source="number" />
            <TextField source="cityName"/>
            <TextField source="streetName" />
            <TextField source="street_suffices" />
        </Datagrid>
    </List>
);

export default DisplayAddresses