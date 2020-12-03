import * as React from "react";
import { List, Datagrid, TextField } from "react-admin";
export const displayBrands = (props) => (
  <List {...props} title="Le modèle">
    <Datagrid rowClick="edit">
      <TextField source="name" />
    </Datagrid>
  </List>
);
export default displayBrands;
