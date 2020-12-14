import * as React from "react";
import {
  List,
  Datagrid,
  TextField,
  NumberField,
  NumberInput,
  EditButton,
  DeleteButton,
  Create,
  Edit,
  SimpleForm,
  ReferenceInput,
  AutocompleteInput,
  TextInput,
} from "react-admin";


const CreateCity = (props) => (
  <Create {...props}>
      <SimpleForm>
      <TextInput source="zipcode" />
      <TextInput source="name" />
      <NumberInput source="latitude" />
      <NumberInput source="longitude" />
      <ReferenceInput source="departmentId" reference="departments">
        <AutocompleteInput optionText="name" optionValue={"id"}/>
      </ReferenceInput>
    </SimpleForm>
  </Create>
);
export default CreateCity
