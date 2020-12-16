import * as React from "react";
import {
  List,
  Datagrid,
  TextField,
  ReferenceField,
  Create,
  Edit,
  SimpleForm,
  ReferenceInput,
  AutocompleteInput,
  TextInput,
} from "react-admin";


const CreateDepartment = (props) => (
  <Create {...props}>
    <SimpleForm>
    <ReferenceInput source="region_id" reference="regions">
        <AutocompleteInput optionText="name" optionValue={"id"}/>
      </ReferenceInput>
      <TextInput source="code" />
      <TextInput source="name" />
    </SimpleForm>
  </Create>
);

export default CreateDepartment
