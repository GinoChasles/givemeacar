import {Datagrid, List, NumberField, TextField, Filter, TextInput,ReferenceInput,SelectInput} from "react-admin";
import * as React from "react";
const PostFilter = (props) => (
    <Filter {...props}>
        <TextInput label="Search" source="q" alwaysOn />
        <ReferenceInput label="User" source="userId" reference="users" allowEmpty>
            <SelectInput optionText="name" />
        </ReferenceInput>
    </Filter>
);
const DisplayCity = (props) => (
    <List {...props} title="Liste des villes" filters={<PostFilter/>}>

        <Datagrid rowClick="edit">
            <TextField source="zipcode" />
            <TextField source="name" />
            <NumberField source="latitude" />
            <NumberField source="longitude" />

            {/* <ReferenceField source="departmentId" reference="departments" sortBy="departments.name">
      <TextField source="name" /> //TODO afficher le nom du département
      </ReferenceField> */}
        </Datagrid>
    </List>
);

export default DisplayCity