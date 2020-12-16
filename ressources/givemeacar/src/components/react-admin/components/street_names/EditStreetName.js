import {Edit, SimpleForm, TextInput} from "react-admin";
import * as React from "react";

const EditStreetName = (props) => (
    <Edit {...props} undoable={false}>
        <SimpleForm>
            <TextInput source="name" />
        </SimpleForm>
    </Edit>
);
export default EditStreetName