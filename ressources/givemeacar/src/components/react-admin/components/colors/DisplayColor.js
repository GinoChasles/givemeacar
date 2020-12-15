import {Datagrid, Filter, List,TextField, TextInput} from "react-admin";
import * as React from "react";

const PostFilter = (props) => (
    <Filter {...props}>
        <TextInput label="Search" source="q" alwaysOn />
    </Filter>
);

const DisplayColor = (props) => (
    <List {...props} title="Liste de couleurs create color" filters={<PostFilter/>}>
        <Datagrid rowClick="edit">
            <TextField source="name" />
        </Datagrid>
    </List>
);
export default DisplayColor