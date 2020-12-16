import * as React from "react";
import {
  List,
  Datagrid,
  TextField,
  Create,
  Edit,
  EmailField,
  SimpleForm,
  TextInput,
  PasswordInput,
} from "react-admin";


const CreateAdministrators = (props) => (
  <Create {...props}>
    <SimpleForm>
      <TextInput source="firstName" />
      <TextInput source="lastName" />
      <TextInput source="mail" />
      <TextInput source="phone" />
      <PasswordInput source="password" />
    </SimpleForm>
  </Create>
);

export default CreateAdministrators
