import {AutocompleteInput, Edit, ReferenceInput, SimpleForm, TextInput} from "react-admin";
import * as React from "react";

const EditModel = (props) => (
    <Edit {...props} undoable={false}>
        <SimpleForm>
            <ReferenceInput source="brand_id" reference="brands">
                <AutocompleteInput optionText="name" optionValue={"id"}/>
            </ReferenceInput>
            <TextInput source="name" />
        </SimpleForm>
    </Edit>
);
export default EditModel