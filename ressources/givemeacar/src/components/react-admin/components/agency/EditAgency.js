import {AutocompleteInput, Edit, ReferenceInput, SimpleForm, TextInput} from "react-admin";
import * as React from "react";

const EditAgency = (props) => (
    <Edit {...props}>
        <SimpleForm>
            <TextInput source="name" />
            <ReferenceInput source="address_id" reference="addresses">
                <AutocompleteInput optionText="name" optionValue={"id"}/>
            </ReferenceInput>
            <ReferenceInput source="manager_id" reference="managers">
                <AutocompleteInput optionText="name" optionValue={"id"}/>
            </ReferenceInput>
        </SimpleForm>
    </Edit>
);

export default EditAgency