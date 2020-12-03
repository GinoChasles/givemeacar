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
    PasswordInput
} from 'react-admin';

export const PostListManager = props => (
    <List {...props}>
      <Datagrid>
           <TextField source="id" />
            <ReferenceField source="userId" reference="users">
                <TextField source="name" />
            </ReferenceField>
            <TextField source="title" />
          <EditButton />
        </Datagrid>
    </List>
);

export const PostEditManager = props => (
    <Edit {...props}>
        <SimpleForm initialValues={postDefaultValue}>
            <TextInput source="agencyid" />
                <TextInput source="firstName" />
                <TextInput source="lastName" />
                <TextInput source="mail" />
                <TextInput source="phone" />
                <PasswordInput source="password" />
            </SimpleForm>
    </Edit>
);
const postDefaultValue = () => ({userStatusId:2 });
export const PostCreateManager = props => (
        <Create {...props}>
            <SimpleForm initialValues={postDefaultValue}>
            <TextInput source="agencyid" />
                <TextInput source="firstName" />
                <TextInput source="lastName" />
                <TextInput source="mail" />
                <TextInput source="phone" />
                <PasswordInput source="password" />
            </SimpleForm>
        </Create>
    );