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
export const DisplayColor = (props) => (
  <List {...props} title="Liste de couleurs create color"> 
    <Datagrid rowClick="edit">
      <TextField source="name" />
    </Datagrid>
  </List>
);

export const EditColor = (props) => (
  <Edit {...props}>
    <SimpleForm>
      <TextInput source="name" />
    </SimpleForm>
  </Edit>
);
export const CreateColor = (props) => (
  <Create {...props}>
    <SimpleForm>
      <TextInput source="name" />
    </SimpleForm>
  </Create>
);
