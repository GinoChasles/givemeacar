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
        <ReferenceInput source="user_id" reference="users" allowEmpty>
            <SearchInput optionText="name" /> //todo ADAPTER LE FORMULAIRE
        </ReferenceInput>
    </Filter>
);
const DisplayCar = (props) => (
    <List {...props} title="Liste des véhicules" filters={<PostFilter/>}>
        <Datagrid rowClick="edit">
            <TextField      source="brandName"      label="brandName" />
            <TextField      source="modelName"      label="modelName" />
            <TextField      source="colorName"      label="colorName" />
            <TextField      source="energy"         label="energy" />
            <NumberField    source="year"           label="year" />

            <NumberField    source="kilometers"     label="kilometers" />
            <NumberField    source="price"          label="price" />

            <TextField      source="energyLevel"    label="energyLevel" />

            <TextField      source="availability"   label="availability" />
            <TextField      source="inRent"        label="inRent" />

            <TextField      source="latitude"       label="latitude" />
            <TextField      source="longitude"      label="longitude" />
        </Datagrid>
    </List>
);
export default DisplayCar