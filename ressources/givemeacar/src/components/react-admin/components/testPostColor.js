import * as React from "react";
import {
    List,
    Datagrid,
    TextField,
    ReferenceField,
    EditButton,
    Create,
    Edit,
    SimpleForm,
    ReferenceInput,
    SelectInput,
    TextInput,
} from 'react-admin';



export const PostEditColor = props => (
    <Edit {...props}>
        <SimpleForm>
           <TextInput disabled source="id" />

            <TextInput source="name" />
        </SimpleForm>
    </Edit>
);
export const PostCreateColor = props => (
        <Create {...props}>
            <SimpleForm>

           <TextInput source="name" />
            </SimpleForm>
        </Create>
    );