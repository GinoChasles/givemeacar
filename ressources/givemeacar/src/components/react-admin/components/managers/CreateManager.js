import * as React from "react";
import {
    Create,
    SimpleForm,
    ReferenceInput,
    AutocompleteInput,
    TextInput,
    PasswordInput,
} from "react-admin";

const CreateManager = (props) => (
    <Create {...props}>
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
    </Create>
);
export default CreateManager
