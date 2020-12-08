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
  AutocompleteInput,
  ArrayInput,
  TextInput,
} from "react-admin";
export const DisplayDepartments = (props) => (
  <List {...props} title="Le département">
    <Datagrid rowClick="edit">
      <TextField source="code" />
      <TextField source="name" />
      <TextField source="region_id" />
    </Datagrid>
  </List>
);
export const EditDepartments = (props) => (
  <Edit {...props}>
    <SimpleForm>
      <ReferenceInput source="region_id" reference="regions">
        <AutocompleteInput optionText="name" />
      </ReferenceInput>
      <TextInput source="code" />
      <TextInput source="name" />
    </SimpleForm>
  </Edit>
);
export const CreateDepartments = (props) => (
  <Create {...props}>
    <SimpleForm>
    <ReferenceInput source="region_id" reference="regions">
        <AutocompleteInput optionText="name" />
      </ReferenceInput>
      
      <TextInput disabled source="region_id" />
      <TextInput source="code" />
      <TextInput source="name" />
    </SimpleForm>
  </Create>
);
