import * as React from "react";
import {
  List,
  Datagrid,
  TextField,
  Create,
  Edit,
  SimpleForm,
  ReferenceInput,
  AutocompleteInput,
  TextInput,
} from "react-admin";


const CreateModel = (props) => (
  <Create {...props}>
    <SimpleForm>
      <ReferenceInput source="brand_id" reference="brands" >
        <AutocompleteInput optionText={"name"} optionValue={"id"}/>
      </ReferenceInput>
      <TextInput source="name" />
    </SimpleForm>
  </Create>
);
export default CreateModel