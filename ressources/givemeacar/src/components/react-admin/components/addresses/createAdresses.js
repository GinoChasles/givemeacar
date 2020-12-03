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
  PasswordInput,
} from "react-admin";

export const DisplayAdresses = (props) => (
  <List {...props} title="Votre adresse">
    <Datagrid rowClick="edit">
      <TextField source="number" />
      <TextField source="city_id" />
      <TextField source="street_id" />
      <TextField source="number_suffix" />
    </Datagrid>
  </List>
);
export const EditAdresses = (props) => (
  <Edit {...props}>
    <SimpleForm>
      <TextInput source="number" />
      <TextInput source="street_id" />
      <TextInput source="city_id" />
      <TextInput source="number_suffix" />
    </SimpleForm>
  </Edit>
);
export const CreateAdresses = (props) => (
  <Create {...props}>
    <SimpleForm>
      <TextInput source="number" />
      <TextInput source="street_id" />
      <TextInput source="city_id" />
      <TextInput source="number_suffix" />
    </SimpleForm>
  </Create>
);
