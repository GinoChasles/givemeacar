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
  EmailField,
  PasswordInput,
} from "react-admin";
export const DisplayManager = (props) => (
  <List {...props} title="les managers">
    <Datagrid rowClick="edit">
      <TextField source="id" />
      <TextField source="firstName" />
      <TextField source="lastName" />
      <EmailField source="mail" />
      <TextField source="phone" />
    </Datagrid>
  </List>
);
export const EditManager = (props) => (
  <Edit {...props}>
    <SimpleForm initialValues={postDefaultValue}>
      <TextInput source="agencyid" />
      <TextInput source="firstName" />
      <TextInput source="lastName" />
      <TextInput source="mail" />
      <TextInput source="phone" />
      <PasswordInput source="password" />
    </SimpleForm>
  </Edit>
);
const postDefaultValue = () => ({ userStatusId: 2 });
export const CreateManager = (props) => (
  <Create {...props}>
    <SimpleForm initialValues={postDefaultValue}>
      <TextInput source="agencyid" />
      <TextInput source="firstName" />
      <TextInput source="lastName" />
      <TextInput source="mail" />
      <TextInput source="phone" />
      <PasswordInput source="password" />
    </SimpleForm>
  </Create>
);
