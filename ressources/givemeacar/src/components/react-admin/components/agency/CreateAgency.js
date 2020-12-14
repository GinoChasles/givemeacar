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


const CreateAgency = (props) => (
  <Create {...props}>
    <SimpleForm>
      <TextInput source="name" />
      <ReferenceInput source="address_id" reference="addresses">
        <AutocompleteInput optionText="name" optionValue={"id"}/>
      </ReferenceInput>
      <ReferenceInput source="manager_id" reference="managers">
        <AutocompleteInput optionText="name" optionValue={"id"}/>
      </ReferenceInput>
    </SimpleForm>
  </Create>
);

export default CreateAgency
