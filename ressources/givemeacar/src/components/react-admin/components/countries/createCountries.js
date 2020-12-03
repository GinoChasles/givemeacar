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
export const DisplayCountries = (props) => (
  <List {...props} title="Votre adresse">
    <Datagrid rowClick="edit">
      <TextField source="name" />
    </Datagrid>
  </List>
);
export const EditCountries = (props) => (
  <Edit {...props}>
    <SimpleForm>
      <TextInput source="name" />
    </SimpleForm>
  </Edit>
);
export const CreateCountries = (props) => (
  <Create {...props}>
    <SimpleForm>
      <TextInput source="name" />
    </SimpleForm>
  </Create>
);
