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
export const DisplayStreets = (props) => (
  <List {...props}>
    <Datagrid rowClick="edit">
      <TextField source="city_id" />
      <TextField source="street_name_id" />
    </Datagrid>
  </List>
);
export const EditStreets = (props) => (
  <Edit {...props}>
    <SimpleForm>
      <ReferenceInput source="city_id" reference="cities">
        <AutocompleteInput optionText="name" />
      </ReferenceInput>
      <ReferenceInput source="street_name_id" reference="street_names">
        <AutocompleteInput optionText="name" />
      </ReferenceInput>
    </SimpleForm>
  </Edit>
);
export const CreateStreets = (props) => (
  <Create {...props}>
    <SimpleForm>
      <ReferenceInput source="city_id" reference="cities">
        <AutocompleteInput optionText="name" />
      </ReferenceInput>
      <ReferenceInput source="street_name_id" reference="street_names">
        <AutocompleteInput optionText="name" />
      </ReferenceInput>
    </SimpleForm>
  </Create>
);
