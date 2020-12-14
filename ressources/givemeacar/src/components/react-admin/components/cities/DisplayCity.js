import {Datagrid, DeleteButton, EditButton, List, NumberField, TextField} from "react-admin";
import * as React from "react";

const DisplayCity = (props) => (
    <List {...props} title="Liste des villes">

        <Datagrid rowClick="edit">
            <TextField source="zipcode" />
            <TextField source="name" />
            <NumberField source="latitude" />
            <NumberField source="longitude" />

            {/* <ReferenceField source="departmentId" reference="departments" sortBy="departments.name">
      <TextField source="name" /> //TODO afficher le nom du département
      </ReferenceField> */}
            <EditButton>Edit</EditButton>
            <DeleteButton>Delete</DeleteButton>
        </Datagrid>

    </List>
);

export default DisplayCity