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
  AutocompleteInput,
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
    {/* <TabbedShowLayout> */}
    <SimpleForm>
      <TextInput source="firstName" />
      <TextInput source="lastName" />
      <TextInput source="mail" />
      <PasswordInput source="password" />
      <TextInput source="phone" />

      <ReferenceInput source="address_id" reference="addresses">
        <AutocompleteInput optionText="name" />
      </ReferenceInput>

      <ReferenceInput source="user_status_id" reference="user_statuses">
        <AutocompleteInput optionText="name" />
      </ReferenceInput>

      <ReferenceInput source="bill_id" reference="bills">
        <AutocompleteInput optionText="id" />
      </ReferenceInput>

      <ReferenceInput source="agency_id" reference="agencies">
        <AutocompleteInput optionText="name" />
      </ReferenceInput>
    </SimpleForm>
    {/* </TabbedShowLayout> */}
  </Edit>
);
export const CreateClient = (props) => (
  <Create {...props}>
    <SimpleForm>
    <TextInput source="firstName" />
    <TextInput source="lastName" />
    <TextInput source="mail" />
    <PasswordInput source="password" />
    <TextInput source="phone" />

    <ReferenceInput source="address_id" reference="addresses">
      <AutocompleteInput optionText="name" />
    </ReferenceInput>

    <ReferenceInput source="user_status_id" reference="user_statuses">
      <AutocompleteInput optionText="name" />
    </ReferenceInput>

    <ReferenceInput source="bill_id" reference="bills" allowEmpty>
      <AutocompleteInput optionText="id" allowEmpty/>
    </ReferenceInput>

    <ReferenceInput source="agency_id" reference="agencies">
      <AutocompleteInput optionText="name" />
    </ReferenceInput>
    </SimpleForm>
  </Create>
);
