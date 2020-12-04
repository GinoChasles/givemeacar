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
export const DisplayEnergyTypes = (props) => (
  <List {...props} title="Votre adresse">
    <Datagrid rowClick="edit">
      <TextField source="number" />
      <TextField source="city_id" />
      <TextField source="street_id" />
      <TextField source="number_suffix" />
    </Datagrid>
  </List>
);
export const EditEnergyTypes = (props) => (
  <Edit {...props}>
    <SimpleForm>
      <TextInput source="name" />
    </SimpleForm>
  </Edit>
);
export const CreateEnergyTypes = (props) => (
  <Create {...props}>
    <SimpleForm>
      <TextInput source="name" />
    </SimpleForm>
  </Create>
);
