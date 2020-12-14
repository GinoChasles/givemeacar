import {Edit, PasswordInput, SimpleForm, TextInput} from "react-admin";
import * as React from "react";

const EditAdministrators = (props) => (
    <Edit {...props}>
        <SimpleForm optionValue={"id"}>
            <TextInput source="firstName" />
            <TextInput source="lastName" />
            <TextInput source="mail" />
            <TextInput source="phone" />
            <PasswordInput source="password" />
        </SimpleForm>
    </Edit>
);

export default EditAdministrators