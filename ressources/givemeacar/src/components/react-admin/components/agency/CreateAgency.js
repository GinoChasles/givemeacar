import * as React from "react";
import {
  Create,
  SimpleForm,
  ReferenceInput,
  AutocompleteInput,
  TextInput,
  NumberInput
} from "react-admin";


const CreateAgency = (props) => (
  <Create {...props}>
    <SimpleForm>
      <TextInput source="name" />

      <NumberInput source="streetNumber" />

      <ReferenceInput source="street_suffix_id" reference="street_suffices">
        <AutocompleteInput optionText="name" optionValue={"id"} />
      </ReferenceInput>

      <ReferenceInput source="street_id" reference="streets">
        <AutocompleteInput optionText="name" optionValue={"id"} />
      </ReferenceInput>

      <ReferenceInput source="city_id" reference="cities">
        <AutocompleteInput optionText="name" optionValue={"id"}/>
      </ReferenceInput>

    </SimpleForm>
  </Create>
);

export default CreateAgency
