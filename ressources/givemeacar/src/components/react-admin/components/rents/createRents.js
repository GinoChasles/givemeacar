import * as React from "react";
import {
  List,
  Datagrid,
  TextField,
  DateTimeInput,
  DateField,
  Create,
  Edit,
  SimpleForm,
  ReferenceInput,
  AutocompleteInput,
} from "react-admin";
export const DisplayRents = (props) => (
  <List {...props} title="Réservation">
    <Datagrid rowClick="edit">
      <DateField source="start" showTime />
      <DateField source="end" showTime/>
      <TextField source="car_id" />
      <TextField source="client_id" />
    </Datagrid>
  </List>
);
export const EditRents = (props) => (
  <Edit {...props}>
    <SimpleForm>
    <DateTimeInput source="start" />
    <DateTimeInput source="end" />
      <ReferenceInput source="car_id" reference="cars">
        <AutocompleteInput optionText="name" optionValue={"id"}/>
      </ReferenceInput>
      <ReferenceInput source="client_id" reference="clients">
        <AutocompleteInput optionText="name" optionValue={"id"}/>
      </ReferenceInput>
    </SimpleForm>
  </Edit>
);
export const CreateRents = (props) => (
  <Create {...props}>
    <SimpleForm>
    <DateTimeInput source="start" />
    <DateTimeInput source="end" />
      <ReferenceInput source="car_id" reference="cars">
        <AutocompleteInput optionText="name" optionValue={"id"}/>
      </ReferenceInput>
      <ReferenceInput source="client_id" reference="clients">
        <AutocompleteInput optionText="name" optionValue={"id"}/>
      </ReferenceInput>
    </SimpleForm>
  </Create>
);
