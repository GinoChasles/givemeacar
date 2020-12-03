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

<<<<<<< HEAD
export const PostListColor = props => (
    <List {...props}>
        <Datagrid>
            <TextField source="id"/>
            <TextField source="title"/>
            <EditButton/>
        </Datagrid>
    </List>
);
=======

>>>>>>> 22d9dba3c205c3112c97624391217d2cb5a085d7

export const PostEditColor = props => (
    <Edit {...props}>
        <SimpleForm>
            <TextInput disabled source="id"/>

            <TextInput source="name"/>
        </SimpleForm>
    </Edit>
);
export const PostCreateColor = props => (
<<<<<<< HEAD
    <Create {...props}>
        <SimpleForm>

            <TextInput source="id" label={"ID"} allowNull={true} disabled />
            <TextInput source="name"/>
        </SimpleForm>
    </Create>
);
=======
        <Create {...props}>
            <SimpleForm>
           
           <TextInput source="name" />
            </SimpleForm>
        </Create>
    );
>>>>>>> 22d9dba3c205c3112c97624391217d2cb5a085d7
