import * as React from "react";
import {Admin,Resource,ListGuesser,ShowGuesser,EditGuesser} from "react-admin";

import jsonServerProvider from "ra-data-json-server"

import {DisplayColor,EditColor,CreateColor} from "../react-admin/components/colors/createColor";
import {DisplayCity,EditCity,CreateCity} from "../react-admin/components/cities/createCities";
import { DisplayBrand,EditBrand,CreateBrand} from "../react-admin/components/brands/createBrands";
import { CreateAddresses, EditAddresses, DisplayAddresses } from '../react-admin/components/addresses'
import {DisplayManager,EditManager,CreateManager} from "../react-admin/components/managers/createManager";
import {DisplayCountries,CreateCountries,EditCountries} from "../react-admin/components/countries/createCountries";
import {DisplayCars,EditCars,CreateCars} from "../react-admin/components/cars/createCar";
import {DisplayClient,EditClient,CreateClient} from "../react-admin/components/clients/createClients";
import {DisplayDepartments,EditDepartments,CreateDepartments,} from "../react-admin/components/departments/createDepartments";
import {DisplayEnergyTypes,EditEnergyTypes,CreateEnergyTypes} from "../react-admin/components/energy_types/createEnergyTypes";
import {DisplayModels,EditModels,CreateModels} from "../react-admin/components/models/createModels";
import {DisplayRegions,EditRegions,CreateRegions} from "../react-admin/components/regions/createRegions";
import {DisplayRents,EditRents,CreateRents} from "../react-admin/components/rents/createRents";
import {DisplayStreetName,EditStreetName,CreateStreetName} from "../react-admin/components/street_names/createStreetName";
import {DisplaySuffices,EditSuffices,CreateSuffices} from "../react-admin/components/street_suffices/createSuffices";
import {DisplayStreets,EditStreets,CreateStreets} from "../react-admin/components/streets/createStreets";


const dataProvider = jsonServerProvider("http://localhost:8080/api");

const ManagerDashboard = () => {
return (
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
      list={DisplayAddresses}
      show={ShowGuesser}
      edit={EditAddresses}
      create={CreateAddresses}
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
    
  </Admin>)}

  export default ManagerDashboard;