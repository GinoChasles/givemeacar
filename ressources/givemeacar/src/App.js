import * as React from "react";
import {
  Admin,
  Resource,
  ListGuesser,
  ShowGuesser,
  EditGuesser,
  Create,
} from "react-admin";
import jsonServerProvider from "ra-data-json-server";
import usersList from "./usersList";
import displayManager from "./components/react-admin/components/managers/displayManager";
import displayBrands from "./components/react-admin/components/brands/displayBrands";
import displayAdministrator from "./components/react-admin/components/administrators/displayAdministrator";
import ListAdresses from "./components/react-admin/components/addresses/displayAdresses";
import displayColor from "./components/react-admin/components/colors/displayColor";
import displayCities from "./components/react-admin/components/cities/displayCities";
import {
  EditAgency,
  CreateAgency,
} from "./components/react-admin/components/agency/createAgency";
import {
  EditColor,
  CreateColor,
} from "./components/react-admin/components/colors/createColor";
import {
  EditCity,
  CreateCity,
} from "./components/react-admin/components/cities/createCities";
import {
  EditBrand,
  CreateBrand,
} from "./components/react-admin/components/brands/createBrands";
import {
  EditAdresses,
  CreateAdresses,
} from "./components/react-admin/components/addresses/createAdresses";

import {
  EditManager,
  CreateManager,
} from "./components/react-admin/components/managers/createManager";
import {
  CreateAdministrator,
  EditAdministrator,
} from "./components/react-admin/components/administrators/createAdministrator";
const dataProvider = jsonServerProvider("http://localhost:8080/api");

const App = () => (
  <Admin dataProvider={dataProvider}>
    <Resource
      options={{ label: "Les couleurs" }}
      name="colors"
      list={displayColor}
      edit={EditColor}
      create={CreateColor}
    />
    <Resource
      name="cities"
      list={displayCities}
      show={ShowGuesser}
      edit={EditCity}
      create={CreateCity}
    />
    <Resource
      name="departments"
      list={ListGuesser}
      show={ShowGuesser}
      edit={EditGuesser}
    />
    <Resource
      options={{ label: "Les managers !" }}
      name="managers"
      list={displayManager}
      show={ShowGuesser}
      edit={EditManager}
      create={CreateManager}
    />
    <Resource
      name="clients"
      list={usersList}
      show={ShowGuesser}
      edit={EditGuesser}
    />
    <Resource
      name="administrators"
      list={displayAdministrator}
      show={ShowGuesser}
      edit={EditAdministrator}
      create={CreateAdministrator}
    />
    <Resource
      name="cars"
      list={ListGuesser}
      show={ShowGuesser}
      edit={EditGuesser}
    />
    <Resource
      name="brands"
      options={{ label: "Les modèles" }}
      list={displayBrands}
      show={ShowGuesser}
      edit={EditBrand}
      create={CreateBrand}
    />
    <Resource
      name="models"
      list={ListGuesser}
      show={ShowGuesser}
      edit={EditGuesser}
    />
    <Resource
      name="addresses"
      list={ListAdresses}
      show={ShowGuesser}
      edit={EditAdresses}
      create={CreateAdresses}
    />
    <Resource
      name="agencies"
      list={ListGuesser}
      show={ShowGuesser}
      edit={EditAgency}
      create={CreateAgency}
    />
    <Resource
      name="bills"
      list={ListGuesser}
      show={ShowGuesser}
      edit={EditGuesser}
    />
    <Resource
      name="rents"
      list={ListGuesser}
      show={ShowGuesser}
      edit={EditGuesser}
    />
    <Resource
      name="energy_types"
      list={ListGuesser}
      show={ShowGuesser}
      edit={EditGuesser}
    />
    <Resource
      name="regions"
      list={ListGuesser}
      show={ShowGuesser}
      edit={EditGuesser}
    />
    <Resource
      name="streets"
      list={ListGuesser}
      show={ShowGuesser}
      edit={EditGuesser}
    />
    <Resource
      name="street_suffices"
      list={ListGuesser}
      show={ShowGuesser}
      edit={EditGuesser}
    />
    <Resource
      name="user_statuses"
      list={ListGuesser}
      show={ShowGuesser}
      edit={EditGuesser}
    />
  </Admin>
);

export default App;
