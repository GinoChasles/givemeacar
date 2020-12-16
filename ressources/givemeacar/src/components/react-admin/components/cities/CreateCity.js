import * as React from "react";
import {
  NumberInput,
  Create,
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
      <ReferenceInput source="department_id" reference="departments">
        <AutocompleteInput optionText="name" optionValue={"id"}/>
      </ReferenceInput>
    </SimpleForm>
  </Create>
);
export default CreateCity
