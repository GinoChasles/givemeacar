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
export const DisplayRents = (props) => (
  <List {...props} title="Réservation">
    <Datagrid rowClick="edit">
      <TextField source="start" />
      <TextField source="end" />
      <TextField source="car_id" />
      <TextField source="client_id" />
    </Datagrid>
  </List>
);
export const EditRents = (props) => (
  <Edit {...props}>
    <SimpleForm>
      <TextInput source="start" />
      <TextInput source="end" />
      <ReferenceInput source="car_id" reference="cars">
        <SelectInput optionText="name" />
      </ReferenceInput>
      <ReferenceInput source="client_id" reference="clients">
        <SelectInput optionText="name" />
      </ReferenceInput>
    </SimpleForm>
  </Edit>
);
export const CreateRents = (props) => (
  <Create {...props}>
    <SimpleForm>
      <TextInput source="start" />
      <TextInput source="end" />
      <ReferenceInput source="car_id" reference="cars">
        <SelectInput optionText="name" />
      </ReferenceInput>
      <ReferenceInput source="client_id" reference="clients">
        <SelectInput optionText="name" />
      </ReferenceInput>
    </SimpleForm>
  </Create>
);
