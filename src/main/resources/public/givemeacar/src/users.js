import * as React from "react";
import { List, Datagrid, TextField, EmailField } from 'react-admin';
import PostPagination from './components/react-admin/components/pagination'
export const UserList = props => (
    <List {...props} title="les villes de l'eeenfer" >
        <Datagrid rowClick="edit" >
            <TextField source="id" />
            <TextField source="name" />
            <TextField source="username" />
            <EmailField source="email" />
            <TextField source="address.street" />
            <TextField source="phone" />
            <TextField source="website" />
        </Datagrid>
    </List>
);
export default UserList;