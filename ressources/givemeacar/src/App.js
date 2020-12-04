import * as React from "react";
import {
  Admin,
  Resource,
  ListGuesser,
  ShowGuesser,
  EditGuesser,
} from "react-admin";
import jsonServerProvider from "ra-data-json-server";

import {
  DisplayAgency,
  EditAgency,
  CreateAgency,
} from "./components/react-admin/components/agency/createAgency";
import {
  DisplayColor,
  EditColor,
  CreateColor,
} from "./components/react-admin/components/colors/createColor";
import {
  DisplayCity,
  EditCity,
  CreateCity,
} from "./components/react-admin/components/cities/createCities";
import {
  DisplayBrand,
  EditBrand,
  CreateBrand,
} from "./components/react-admin/components/brands/createBrands";
import {
  DisplayAdresses,
  EditAdresses,
  CreateAdresses,
} from "./components/react-admin/components/addresses/createAdresses";

import {
  DisplayManager,
  EditManager,
  CreateManager,
} from "./components/react-admin/components/managers/createManager";
import {
  DisplayAdministrators,
  CreateAdministrators,
  EditAdministrators,
} from "./components/react-admin/components/administrators/createAdministrator";
import {
  DisplayCountries,
  CreateCountries,
  EditCountries,
} from "./components/react-admin/components/countries/createCountries";
import {
  DisplayCars,
  EditCars,
  CreateCars,
} from "./components/react-admin/components/cars/createCar";
import {
  DisplayClient,
  EditClient,
  CreateClient,
} from "./components/react-admin/components/clients/createClients";
import {
  DisplayDepartments,
  EditDepartments,
  CreateDepartments,
} from "./components/react-admin/components/departments/createDepartments";
import {
  DisplayEnergyTypes,
  EditEnergyTypes,
  CreateEnergyTypes,
} from "./components/react-admin/components/energy_types/createEnergyTypes";
import {
  DisplayModels,
  EditModels,
  CreateModels,
} from "./components/react-admin/components/models/createModels";
import {
  DisplayRegions,
  EditRegions,
  CreateRegions,
} from "./components/react-admin/components/regions/createRegions";
import {
  DisplayRents,
  EditRents,
  CreateRents,
} from "./components/react-admin/components/rents/createRents";
import {
  DisplayStreetName,
  EditStreetName,
  CreateStreetName,
} from "./components/react-admin/components/street_names/createStreetName";
import {
  DisplaySuffices,
  EditSuffices,
  CreateSuffices,
} from "./components/react-admin/components/street_suffices/createSuffices";
import {
  DisplayStreets,
  EditStreets,
  CreateStreets,
} from "./components/react-admin/components/streets/createStreets";
import {
  DisplayStatuses,
  EditStatuses,
  CreateStatuses,
} from "./components/react-admin/components/user_statuses/createStatuses";
const dataProvider = jsonServerProvider("http://localhost:8080/api");

const App = () => (
  <Admin dataProvider={dataProvider}>
    <Resource
      options={{ label: "Les couleurs" }}
      name="colors"
      list={DisplayColor}
      edit={EditColor}
      create={CreateColor}
    />
    <Resource
      name="cities"
      list={DisplayCity}
      show={ShowGuesser}
      edit={EditCity}
      create={CreateCity}
    />
    <Resource
      name="departments"
      list={DisplayDepartments}
      show={ShowGuesser}
      edit={EditDepartments}
      create={CreateDepartments}
    />
    <Resource
      options={{ label: "Les managers !" }}
      name="managers"
      list={DisplayManager}
      show={ShowGuesser}
      edit={EditManager}
      create={CreateManager}
    />
    <Resource
      name="clients"
      list={DisplayClient}
      show={ShowGuesser}
      edit={EditClient}
      create={CreateClient}
    />
    <Resource
      name="administrators"
      list={DisplayAdministrators}
      show={ShowGuesser}
      edit={EditAdministrators}
      create={CreateAdministrators}
    />
    <Resource
      name="cars"
      list={DisplayCars}
      show={ShowGuesser}
      edit={EditCars}
      create={CreateCars}
    />
    <Resource
      name="brands"
      options={{ label: "Les modèles" }}
      list={DisplayBrand}
      show={ShowGuesser}
      edit={EditBrand}
      create={CreateBrand}
    />
    <Resource
      name="models"
      list={DisplayModels}
      show={ShowGuesser}
      edit={EditModels}
      create={CreateModels}
    />
    <Resource
      name="addresses"
      list={DisplayAdresses}
      show={ShowGuesser}
      edit={EditAdresses}
      create={CreateAdresses}
    />
    <Resource
      name="agencies"
      list={DisplayAgency}
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
      list={DisplayRents}
      show={ShowGuesser}
      edit={EditRents}
      create={CreateRents}
    />
    <Resource
      name="energy_types"
      list={DisplayEnergyTypes}
      show={ShowGuesser}
      edit={EditEnergyTypes}
      create={CreateEnergyTypes}
    />
    <Resource
      name="regions"
      list={DisplayRegions}
      show={ShowGuesser}
      edit={EditRegions}
      create={CreateRegions}
    />
    <Resource
      name="streets"
      list={DisplayStreets}
      show={ShowGuesser}
      edit={EditStreets}
      create={CreateStreets}
    />
    <Resource
      name="street_suffices"
      list={DisplaySuffices}
      show={ShowGuesser}
      edit={EditSuffices}
      create={CreateSuffices}
    />
    <Resource
      name="street_names"
      list={DisplayStreetName}
      show={ShowGuesser}
      edit={EditStreetName}
      create={CreateStreetName}
    />
    <Resource
      name="countries"
      list={DisplayCountries}
      show={ShowGuesser}
      edit={EditCountries}
      create={CreateCountries}
    />
    <Resource
      name="user_statuses"
      list={DisplayStatuses}
      show={ShowGuesser}
      edit={EditStatuses}
      create={CreateStatuses}
    />
  </Admin>
);

export default App;