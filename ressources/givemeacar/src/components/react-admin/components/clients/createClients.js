import * as React from "react";
import {
  List,
  Datagrid,
  TextField,
  ReferenceField,
  EditButton,
  PasswordInput,
  Create,
  Edit,
  SimpleForm,
  ReferenceInput,
  SelectInput,
  TextInput,
} from "react-admin";
export const DisplayClient = (props) => (
  <List {...props} title="Liste des clients">
    <Datagrid rowClick="edit">
      <TextField source="first_name" />
      <TextField source="last_name" />
      <TextField source="mail" />
      <TextField source="password" />
      <TextField source="phone" />
      <TextField source="address_id" />
      <TextField source="user_status_id" />
      <TextField source="bill_id" />
      <TextField source="credit_card_id" />
      <TextField source="agency_id" />
    </Datagrid>
  </List>
);

export const EditClient = (props) => (
  <Edit {...props}>
    <SimpleForm>
      <TextInput source="first_name" />
      <TextInput source="last_name" />
      <TextInput source="mail" />
      <PasswordInput source="password" />
      <TextInput source="phone" />
      <ReferenceInput source="address_id" reference="addresses">
        <SelectInput optionText="id" />
      </ReferenceInput>
      <ReferenceInput source="user_status_id" reference="user_statuses">
        <SelectInput optionText="id" />
      </ReferenceInput>
      <ReferenceInput source="bill_id" reference="bills">
        <SelectInput optionText="id" />
      </ReferenceInput>
      <ReferenceInput source="agency_id" reference="agencies">
        <SelectInput optionText="name" />
      </ReferenceInput>
    </SimpleForm>
  </Edit>
);
export const CreateClient = (props) => (
  <Create {...props}>
    <TextInput source="first_name" />
    <TextInput source="last_name" />
    <TextInput source="mail" />
    <PasswordInput source="password" />
    <TextInput source="phone" />
    <ReferenceInput source="address_id" reference="addresses">
      <SelectInput optionText="id" />
    </ReferenceInput>
    <ReferenceInput source="user_status_id" reference="user_statuses">
      <SelectInput optionText="id" />
    </ReferenceInput>
    <ReferenceInput source="bill_id" reference="bills">
      <SelectInput optionText="id" />
    </ReferenceInput>
    <ReferenceInput source="agency_id" reference="agencies">
      <SelectInput optionText="name" />
    </ReferenceInput>
  </Create>
);
