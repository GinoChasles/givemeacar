import * as React from "react";
import { List, Datagrid, TextField, EmailField } from 'react-admin';
// import PostPagination from './components/react-admin/components/pagination'
export const UserListManager = props => (
    <List {...props} title="les villes de l'eeenfer" >
        <Datagrid rowClick="edit" >
            <TextField source="id"  />
            <TextField source="firstName" />
            <TextField source="lastName" />
            <EmailField source="mail" />
            <TextField source="phone" />
            
        </Datagrid>
    </List>
);
export default UserListManager;