import {Edit, SimpleForm, TextInput} from "react-admin";
import * as React from "react";

const EditStatus = (props) => (
    <Edit {...props} undoable={false}>
        <SimpleForm>
            <TextInput source="name" />
        </SimpleForm>
    </Edit>
);
export default EditStatus