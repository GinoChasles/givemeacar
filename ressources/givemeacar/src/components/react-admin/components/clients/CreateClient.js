import * as React from "react";
import {
  List,
  Datagrid,
  TextField,
  PasswordInput,
  Create,
  Edit,
  SimpleForm,
  ReferenceInput,
  AutocompleteInput,
  TextInput,
  NumberInput
} from "react-admin";



const CreateClient = (props) => (
  <Create {...props}>
    <SimpleForm>
    <TextInput source="firstName" />
    <TextInput source="lastName" />
    <TextInput source="mail" />
    <PasswordInput source="password" />
    <TextInput source="phone" />

      <NumberInput source="streetNumber" />

      <ReferenceInput source="street_suffix_id" reference="street_suffices">
        <AutocompleteInput optionText="name" optionValue={"id"} />
      </ReferenceInput>

      <ReferenceInput source="street_id" reference="streets">
        <AutocompleteInput optionText="name" optionValue={"id"} />
      </ReferenceInput>

      <ReferenceInput source="city_id" reference="cities">
        <AutocompleteInput optionText="name" optionValue={"id"} />
      </ReferenceInput>

    <ReferenceInput source="agency_id" reference="agencies">
      <AutocompleteInput optionText="name" optionValue={"id"}/>
    </ReferenceInput>
    </SimpleForm>
  </Create>
);
export default CreateClient