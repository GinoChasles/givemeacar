import * as React from "react";
import {
  Create,
  SimpleForm,
  TextInput,
} from "react-admin";


const CreateBrand = (props) => (
  <Create {...props}>
    <SimpleForm>
      <TextInput source="name" />
    </SimpleForm>
  </Create>
);
export default CreateBrand
