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
export const DisplayAgency = (props) => (
  <List {...props} title="Votre adresse">
    <Datagrid rowClick="edit">
      <TextField source="name" />
      <TextField source="address_id" />
      <TextField source="manager_id" />
    </Datagrid>
  </List>
);
export const EditAgency = (props) => (
  <Edit {...props}>
    <SimpleForm>
      <TextInput source="name" />
      <ReferenceInput source="address_id" reference="addresses">
        <SelectInput optionText="name" />
      </ReferenceInput>
      <ReferenceInput source="manager_id" reference="managers">
        <SelectInput optionText="name" />
      </ReferenceInput>
    </SimpleForm>
  </Edit>
);
export const CreateAgency = (props) => (
  <Create {...props}>
    <SimpleForm>
      <TextInput source="name" />
      <ReferenceInput source="address_id" reference="addresses">
        <SelectInput optionText="name" />
      </ReferenceInput>
      <ReferenceInput source="manager_id" reference="managers">
        <SelectInput optionText="name" />
      </ReferenceInput>
    </SimpleForm>
  </Create>
);
