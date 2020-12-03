import * as React from "react";
import { List, Datagrid, TextField } from "react-admin";
export const displayColor = (props) => (
  <List {...props} title="Votre adresse">
    <Datagrid rowClick="edit">
      <TextField source="name" />
    </Datagrid>
  </List>
);
export default displayColor;
