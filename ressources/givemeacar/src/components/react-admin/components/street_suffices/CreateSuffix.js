import * as React from "react";
import {
  Create,
  SimpleForm,
  TextInput,
} from "react-admin";


const CreateSuffix = (props) => (
  <Create {...props}>
    <SimpleForm>
      <TextInput source="name" />
    </SimpleForm>
  </Create>
);
export default CreateSuffix
