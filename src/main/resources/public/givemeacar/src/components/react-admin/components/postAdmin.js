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

export const PostListAdmin = props => (
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

export const PostEditAdmin = props => (
    <Edit {...props}>
        <SimpleForm>
           <TextInput disabled source="id" />
            <ReferenceInput source="userId" reference="users">
              <SelectInput optionText="name" />
            </ReferenceInput>
            <TextInput source="title" />
           <TextInput multiline source="body" />
        </SimpleForm>
    </Edit>
);
const postDefaultValue = () => ({userStatusId:1, agencyid:1 });
export const PostCreateAdmin = props => (
        <Create {...props}>
            <SimpleForm initialValues={postDefaultValue}>
            <TextInput disabled source="userStatusId" />
            <TextInput source="agencyid" />
                <TextInput source="firstName" />
                <TextInput source="lastName" />
                <TextInput source="mail" />
                <TextInput source="phone" />
                <TextInput source="password" />
            </SimpleForm>
        </Create>
    );