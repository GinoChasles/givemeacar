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
} from "react-admin";


const CreateStreet = (props) => (
  <Create {...props}>
    <SimpleForm>
      <ReferenceInput source="city_id" reference="cities">
        <AutocompleteInput optionText="name" optionValue={"id"}/>
      </ReferenceInput>
      <ReferenceInput source="street_name_id" reference="street_names">
        <AutocompleteInput optionText="name" optionValue={"id"}/>
      </ReferenceInput>
    </SimpleForm>
  </Create>
);
export default CreateStreet
