import * as React from "react";
import {
  List,
  Datagrid,
  TextField,
  Create,
  Edit,
  SimpleForm,
  TextInput,
} from "react-admin";

const CreateStreet = (props) => (
  <Create {...props}>
    <SimpleForm>
      <TextInput source="name" />
    </SimpleForm>
  </Create>
);
export default CreateStreet