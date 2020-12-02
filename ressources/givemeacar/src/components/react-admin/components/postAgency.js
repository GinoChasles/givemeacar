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

export const PostListAgency = props => (
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

export const PostEditAgency = props => (
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
export const PostCreateAgency = props => (
        <Create {...props}>
            <SimpleForm>
                <ReferenceInput source="userId" reference="users">
                    <SelectInput optionText="name" />
                </ReferenceInput>
                <TextInput source="title" />
                <TextInput multiline source="body" />
            </SimpleForm>
        </Create>
    );