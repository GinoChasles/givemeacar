import * as React from "react";
import { List, Datagrid, TextField, EmailField } from 'react-admin';

export const UserList = props => (
<<<<<<< HEAD
    <List {...props}>
        <Datagrid rowClick="edit">
=======
    <List {...props} title="les villes de l'eeenfer" label= "stp">
        <Datagrid rowClick="edit" >
>>>>>>> gino
            <TextField source="id" />
            <TextField source="name" />
            <TextField source="username" />
            <EmailField source="email" />
            <TextField source="address.street" />
            <TextField source="phone" />
            <TextField source="website" />
        </Datagrid>
    </List>
<<<<<<< HEAD
);
=======
);
export default UserList;
>>>>>>> gino
