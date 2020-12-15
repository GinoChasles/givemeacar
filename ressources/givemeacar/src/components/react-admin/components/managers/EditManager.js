import {AutocompleteInput, Edit, PasswordInput, ReferenceInput, SimpleForm, TextInput} from "react-admin";
import * as React from "react";

const EditManager = (props) => (
    <Edit {...props} undoable={false}>
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

export default EditManager