import * as React from "react";
import { List, Datagrid, TextField } from "react-admin";
export const ListAdresses = (props) => (
  <List {...props} title="Votre adresse">
    <Datagrid rowClick="edit">
      <TextField source="number" />
      <TextField source="city_id" />
      <TextField source="street_id" />
      <TextField source="number_suffix" />
    </Datagrid>
  </List>
);
export default ListAdresses;
