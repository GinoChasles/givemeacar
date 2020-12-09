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
  EmailField,
  PasswordInput,
} from "react-admin";
export const DisplayManager = (props) => (
  <List {...props} title="les managers">
    <Datagrid rowClick="edit">
        {/* <ReferenceField source="agencyId" reference="agencies" sortBy="agencies.name">
      <TextField source="name" /> //TODO afficher agences auquel le manager appartient
      </ReferenceField> */}
      <TextField source="id" />
      <TextField source="firstName" />
      <TextField source="lastName" />
      <EmailField source="mail" />
      <TextField source="phone" />
    </Datagrid>
  </List>
);
export const EditManager = (props) => (
  <Edit {...props}>
    <SimpleForm>
    <ReferenceInput label="nom de l'agence" source="agencyId" reference="agencies">
        <AutocompleteInput optionText="name" optionValue={"id"} />
      </ReferenceInput>
      <TextInput source="firstName" />
      <TextInput source="lastName" />
      <TextInput source="mail" />
      <TextInput source="phone" />
      <PasswordInput source="password" />
    </SimpleForm>
  </Edit>
);
/*const postDefaultValue = () => ({ userStatusId: 2 }); initialValues={postDefaultValue*/
export const CreateManager = (props) => (
  <Create {...props}>
    <SimpleForm >
      <ReferenceInput label="nom de l'agence" source="agencyId" reference="agencies">
              <AutocompleteInput optionText="name" optionValue={"id"} /> //TODO optionValue a rajouter dans chaque autocomplete
            </ReferenceInput>
      <TextInput source="firstName" />
      <TextInput source="lastName" />
      <TextInput source="mail" />
      <TextInput source="phone" />
      <PasswordInput source="password" />
    </SimpleForm>
  </Create>
);
