import {AutocompleteInput, Edit, NumberInput, ReferenceInput, SimpleForm, TextInput} from "react-admin";
import * as React from "react";

const EditCity = (props) => (
    <Edit {...props} undoable={false}>
        <SimpleForm>
            <TextInput source="zipcode" />
            <TextInput source="name" />
            <NumberInput source="latitude" />
            <NumberInput source="longitude" />
            <ReferenceInput source="department_id" reference="departments">
                <AutocompleteInput optionText="name" optionValue={"id"}/>
            </ReferenceInput>
        </SimpleForm>
    </Edit>
);

export default EditCity