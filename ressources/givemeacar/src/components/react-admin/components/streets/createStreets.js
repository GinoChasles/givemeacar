import * as React from "react";
import {
  List,
  Datagrid,
  TextField,
  ReferenceField,
  EditButton,
  Create,
  Edit,
  SimpleForm,
  ReferenceInput,
  SelectInput,
  TextInput,
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
        <SelectInput optionText="name" />
      </ReferenceInput>
      <ReferenceInput source="street_name_id" reference="street_names">
        <SelectInput optionText="name" />
      </ReferenceInput>
    </SimpleForm>
  </Edit>
);
export const CreateStreets = (props) => (
  <Create {...props}>
    <SimpleForm>
      <ReferenceInput source="city_id" reference="cities">
        <SelectInput optionText="name" />
      </ReferenceInput>
      <ReferenceInput source="street_name_id" reference="street_names">
        <SelectInput optionText="name" />
      </ReferenceInput>
    </SimpleForm>
  </Create>
);
