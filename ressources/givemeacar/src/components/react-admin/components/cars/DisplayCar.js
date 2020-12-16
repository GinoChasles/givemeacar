import {
    BooleanField,
    Datagrid,
    Filter,
    List,
    NumberField,
    ReferenceField,
    ReferenceInput, SearchInput,
    TextField
} from "react-admin";
import * as React from "react";
const PostFilter = (props) => (
    <Filter {...props}>
        <SearchInput source="q" alwaysOn />
        <ReferenceInput source="userId" reference="users" allowEmpty>
            <SearchInput optionText="name" /> //todo ADAPTER LE FORMULAIRE
        </ReferenceInput>
    </Filter>
);
const DisplayCar = (props) => (
    <List {...props} title="Liste des véhicules" filters={<PostFilter/>}>
        <Datagrid rowClick="edit">
            <NumberField source="kilometers" />
            <NumberField source="price" />
            <NumberField source="year" />
            <BooleanField source="available" default={true}/>
            <BooleanField source="rented" default={false}/>
            <TextField source="model_id" />
            <ReferenceField source="model_id" reference="models">
                <TextField source="name" />
            </ReferenceField>
            <TextField source="energy_id" />
            <TextField source="color_id" />
            <TextField source="energy_max" />
            <TextField source="energy_current" />
            <TextField source="energy_type_id" />
            <TextField source="latitude" />
            <TextField source="longitude" />
            <TextField source="number_suffix" />
        </Datagrid>
    </List>
);
export default DisplayCar