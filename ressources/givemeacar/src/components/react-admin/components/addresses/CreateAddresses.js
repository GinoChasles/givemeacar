import * as React from "react";
import {
  Create,
  SimpleForm,
  ReferenceInput,
  AutocompleteInput,
  TextInput
} from "react-admin";

const CreateAddresses = (props) => (
  <Create {...props} >
    <SimpleForm>
      <TextInput source="number" />
      <ReferenceInput source="street_suffices_id" reference="street_suffices">
        <AutocompleteInput optionText="name" optionValue={"id"}/>
      </ReferenceInput>
      <ReferenceInput source="street_id" reference="streets">
        <AutocompleteInput optionText="name" optionValue={"id"}/>
      </ReferenceInput>
      <ReferenceInput source="city_id" reference="cities">
        <AutocompleteInput optionText="name" optionValue={"id"}/>
      </ReferenceInput>
    </SimpleForm>
  </Create>
);

export default CreateAddresses