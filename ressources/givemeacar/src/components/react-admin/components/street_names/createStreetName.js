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
export const DisplayStreetName = (props) => (
  <List {...props} title="Nom des rues">
    <Datagrid rowClick="edit">
      <TextField source="name" />
    </Datagrid>
  </List>
);
export const EditStreetName = (props) => (
  <Edit {...props}>
    <SimpleForm>
      <TextInput source="name" />
    </SimpleForm>
  </Edit>
);
export const CreateStreetName = (props) => (
  <Create {...props}>
    <SimpleForm>
      <TextInput source="name" />
    </SimpleForm>
  </Create>
);
