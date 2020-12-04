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
  PasswordInput,
} from "react-admin";

export const DisplayAdresses = (props) => (
  <List {...props} title="Votre adresse">
    <Datagrid rowClick="edit">
      <TextField source="number" />
      <TextField source="city_id" />
      <TextField source="street_id" />
      <TextField source="street_suffices" />
    </Datagrid>
  </List>
);
export const EditAdresses = (props) => (
  <Edit {...props}>
    <SimpleForm>
      <TextInput source="number" />
      <ReferenceInput source="street_suffices_id" reference="street_suffices">
        <SelectInput optionText="name" />
      </ReferenceInput>
      <ReferenceInput source="street_id" reference="streets">
        <SelectInput optionText="name" />
      </ReferenceInput>
      <ReferenceInput source="city_id" reference="cities">
        <SelectInput optionText="name" />
      </ReferenceInput>
    </SimpleForm>
  </Edit>
);
export const CreateAdresses = (props) => (
  <Create {...props}>
    <SimpleForm>
      <TextInput source="number" />
      <ReferenceInput source="street_suffices_id" reference="street_suffices">
        <SelectInput optionText="name" />
      </ReferenceInput>
      <ReferenceInput source="street_id" reference="streets">
        <SelectInput optionText="name" />
      </ReferenceInput>
      <ReferenceInput source="city_id" reference="cities">
        <SelectInput optionText="name" />
      </ReferenceInput>
    </SimpleForm>
  </Create>
);
