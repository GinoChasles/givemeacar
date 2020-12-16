import * as React from "react";
import {
  List,
  Datagrid,
  TextField,
  PasswordInput,
  Create,
  Edit,
  SimpleForm,
  ReferenceInput,
  AutocompleteInput,
  TextInput,
} from "react-admin";



const CreateClient = (props) => (
  <Create {...props}>
    <SimpleForm>
    <TextInput source="firstName" />
    <TextInput source="lastName" />
    <TextInput source="mail" />
    <PasswordInput source="password" />
    <TextInput source="phone" />

    <ReferenceInput source="address_id" reference="addresses">
      <AutocompleteInput optionText="name" optionValue={"id"}/>
    </ReferenceInput>

    <ReferenceInput source="user_status_id" reference="user_statuses">
      <AutocompleteInput optionText="name" optionValue={"id"}/>
    </ReferenceInput>

    <ReferenceInput source="bill_id" reference="bills" allowEmpty>
      <AutocompleteInput optionText="name" optionValue={"id"}/>
    </ReferenceInput>

    <ReferenceInput source="agency_id" reference="agencies">
      <AutocompleteInput optionText="name" optionValue={"id"}/>
    </ReferenceInput>
    </SimpleForm>
  </Create>
);
export default CreateClient