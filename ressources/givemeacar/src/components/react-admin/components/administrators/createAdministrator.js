import * as React from "react";
import {
  List,
  Datagrid,
  TextField,
  ReferenceField,
  EditButton,
  Create,
  Edit,
  EmailField,
  SimpleForm,
  ReferenceInput,
  SelectInput,
  TextInput,
  PasswordInput,
} from "react-admin";
export const DisplayAdministrators = (props) => (
  <List {...props} title="les villes de l'eeenfer">
    <Datagrid rowClick="edit">
      <TextField source="id" />
      <TextField source="firstName" />
      <TextField source="lastName" />
      <EmailField source="mail" />
      <TextField source="phone" />
    </Datagrid>
  </List>
);
export const EditAdministrators = (props) => (
  <Edit {...props}>
    <SimpleForm>
      <TextInput disabled source="id" />
      <ReferenceInput source="userId" reference="users">
        <SelectInput optionText="name" />
      </ReferenceInput>
      <TextInput source="title" />
      <TextInput multiline source="body" />
    </SimpleForm>
  </Edit>
);
const postDefaultValue = () => ({ userStatusId: 1 });
export const CreateAdministrators = (props) => (
  <Create {...props}>
    <SimpleForm initialValues={postDefaultValue}>
      <TextInput disabled source="userStatusId" />
      <TextInput source="firstName" />
      <TextInput source="lastName" />
      <TextInput source="mail" />
      <TextInput source="phone" />
      <PasswordInput source="password" />
    </SimpleForm>
  </Create>
);
