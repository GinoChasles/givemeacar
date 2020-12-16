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


const CreateRent = (props) => (
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
export default CreateRent