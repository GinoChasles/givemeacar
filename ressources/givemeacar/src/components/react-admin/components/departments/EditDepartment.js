import {AutocompleteInput, Edit, ReferenceInput, SimpleForm, TextInput} from "react-admin";
import * as React from "react";

const EditDepartments = (props) => (
    <Edit {...props}>
        <SimpleForm>
            <ReferenceInput source="region_id" reference="regions">
                <AutocompleteInput optionText="name" optionValue={"id"}/>
            </ReferenceInput>
            <TextInput source="code" />
            <TextInput source="name" />
        </SimpleForm>
    </Edit>
);

export default EditDepartments