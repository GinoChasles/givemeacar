import * as React from "react";
import { List, Datagrid, TextField } from "react-admin";
export const displayCar = (props) => (
  <List {...props} title="Liste des véhicules">
    <Datagrid rowClick="edit">
      <TextField source="number" />
      <TextField source="city_id" />
      <TextField source="street_id" />
      <TextField source="number_suffix" />
    </Datagrid>
  </List>
);
export default displayCar;
id,
  kilometers,
  price,
  year,
  available,
  rented,
  model_id,
  energy_id,
  color_id,
  energy_max,
  energy_current,
  energy_type_id,
  latitude,
  longitude;
