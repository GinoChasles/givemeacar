import * as React from "react";
import {
  List,
  Datagrid,
  TextField,
  ReferenceField,
  EditButton,
  Create,
  Edit,
  SimpleForm,
  ReferenceInput,
  SelectInput,
  TextInput,
} from "react-admin";
export const DisplayCars = (props) => (
  <List {...props} title="Liste des véhicules">
    <Datagrid rowClick="edit">
      <TextField source="kilometers" />
      <TextField source="price" />
      <TextField source="year" />
      <TextField source="available" />
      <TextField source="rented" />
      <TextField source="model_id" />
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
export const EditCars = (props) => (
  <Edit {...props}>
    <SimpleForm>
      <TextInput disabled source="id" />
      <ReferenceInput source="userId" reference="users">
        <SelectInput optionText="name" />
      </ReferenceInput>
      <TextInput source="kilometers" />
      <TextInput source="price" />
      <TextInput source="year" />
      <TextInput source="available" />
      <TextInput source="rented" />
      <ReferenceInput source="model_id" reference="model">
        <SelectInput optionText="name" />
      </ReferenceInput>
      <TextInput source="energy_id" />
      <TextInput source="color_id" />
      <TextInput source="energy_max" />
      <TextInput source="energy_current" />
      <TextInput source="energy_type_id" />
      <TextInput source="latitude" />
      <TextInput source="longitude" />
      <TextInput source="number_suffix" />
    </SimpleForm>
  </Edit>
);
export const CreateCars = (props) => (
  <Create {...props}>
    <SimpleForm>
      <TextInput source="kilometers" />
      <TextInput source="price" />
      <TextInput source="year" />
      <TextInput source="available" />
      <TextInput source="rented" />
      <TextInput source="model_id" />
      <TextInput source="energy_id" />
      <TextInput source="color_id" />
      <TextInput source="energy_max" />
      <TextInput source="energy_current" />
      <TextInput source="energy_type_id" />
      <TextInput source="latitude" />
      <TextInput source="longitude" />
      <TextInput source="number_suffix" />
    </SimpleForm>
  </Create>
);
