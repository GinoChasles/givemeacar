import {Edit, SimpleForm, TextInput} from "react-admin";
import * as React from "react";

const EditSuffix = (props) => (
    <Edit {...props}>
        <SimpleForm>
            <TextInput source="name" />
        </SimpleForm>
    </Edit>
);
export default EditSuffix