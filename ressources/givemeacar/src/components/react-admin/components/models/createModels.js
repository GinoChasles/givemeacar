import * as React from "react";
import {
  List,
  Datagrid,
  TextField,
  Create,
  Edit,
  SimpleForm,
  ReferenceInput,
  AutocompleteInput,
  TextInput,
} from "react-admin";
export const DisplayModels = (props) => (
  <List {...props} title="Modèles">
    <Datagrid rowClick="edit">
      <TextField source="name" />
      <TextField source="brand_id" />
    </Datagrid>
  </List>
);
export const EditModels = (props) => (
  <Edit {...props}>
    <SimpleForm>
      <ReferenceInput source="brand_id" reference="brands">
        <AutocompleteInput optionText="name" optionValue={"id"}/>
      </ReferenceInput>
      <TextInput source="name" />
    </SimpleForm>
  </Edit>
);
export const CreateModels = (props) => (
  <Create {...props}>
    <SimpleForm>
      <ReferenceInput source="brand_id" reference="brands" >
        <AutocompleteInput optionText={"name"} optionValue={"id"}/>
      </ReferenceInput>
      <TextInput source="name" />
    </SimpleForm>
  </Create>
);
