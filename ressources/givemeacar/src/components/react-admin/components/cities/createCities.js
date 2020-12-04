import * as React from "react";
import {
  List,
  Datagrid,
  TextField,
  ReferenceField,
  NumberField,
  NumberInput,
  EditButton,
  DeleteButton,
  Create,
  Edit,
  SimpleForm,
  ReferenceInput,
  SelectInput,
  TextInput,
} from "react-admin";
export const DisplayCity = (props) => (
  <List {...props} title="Liste des villes">
    <Datagrid rowClick="edit">
      <TextField source="zipcode" />
      <TextField source="name" />
      <NumberField source="latitude" />
      <NumberField source="longitude" />
      {/* <ReferenceField source="departmentId" reference="departments" sortBy="departments.name">
      <TextField source="name" /> //TODO afficher le nom du département 
      </ReferenceField> */}
      <EditButton>Edit</EditButton>
      <DeleteButton>Delete</DeleteButton>
    </Datagrid>
  </List>
);
export const EditCity = (props) => (
  <Edit {...props}>
    <SimpleForm>
      <TextInput source="zipcode" />
      <TextInput source="name" />
      <NumberInput source="latitude" />
      <NumberInput source="longitude" />
      <ReferenceInput source="departmentId" reference="departments">
        <SelectInput optionText="name" />
      </ReferenceInput>
    </SimpleForm>
  </Edit>
);
export const CreateCity = (props) => (
  <Create {...props}>
      <SimpleForm>
      <TextInput source="zipcode" />
      <TextInput source="name" />
      <NumberInput source="latitude" />
      <NumberInput source="longitude" />
      <ReferenceInput source="departmentId" reference="departments">
        <SelectInput optionText="name" />
      </ReferenceInput>
    </SimpleForm>
  </Create>
);
