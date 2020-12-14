import * as React from "react";
import {Admin,Resource,ListGuesser,ShowGuesser,EditGuesser} from "react-admin";

import jsonServerProvider from "ra-data-json-server"

import {DisplayColor,EditColor,CreateColor} from "../react-admin/components/colors/CreateColor";
import {DisplayCity,EditCity,CreateCity} from "../react-admin/components/cities/CreateCity";
import { DisplayBrand,EditBrand,CreateBrand} from "../react-admin/components/brands/CreateBrand";
import { CreateAddresses, EditAddresses, DisplayAddresses } from '../react-admin/components/addresses'
import {DisplayManager,EditManager,CreateManager} from "../react-admin/components/managers/CreateManager.js";
import {DisplayCountries,CreateCountry,EditCountries} from "../react-admin/components/countries/CreateCountry";
import {DisplayCars,EditCars,CreateCars} from "../react-admin/components/cars/CreateCar";
import {DisplayClient,EditClient,CreateClient} from "../react-admin/components/clients/CreateClient";
import {DisplayDepartments,EditDepartments,CreateDepartment,} from "../react-admin/components/departments/CreateDepartment";
import {DisplayEnergyTypes,EditEnergyTypes,CreateEnergyType} from "../react-admin/components/energy_types/CreateEnergyType";
import {DisplayModels,EditModels,CreateModel} from "../react-admin/components/models/CreateModel";
import {DisplayRegions,EditRegions,CreateRegion} from "../react-admin/components/regions/CreateRegion";
import {DisplayRents,EditRents,CreateRent} from "../react-admin/components/rents/CreateRent";
import {DisplayStreetName,EditStreetName,CreateStreetName} from "../react-admin/components/street_names/CreateStreetName";
import {DisplaySuffices,EditSuffices,CreateSuffix} from "../react-admin/components/street_suffices/CreateSuffix";
import {DisplayStreets,EditStreets,CreateStreet} from "../react-admin/components/streets/CreateStreet";


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
      create={CreateDepartment}
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
      create={CreateModel}
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
      create={CreateRent}
    />
    <Resource
      name="energy_types"
      list={DisplayEnergyTypes}
      show={ShowGuesser}
      edit={EditEnergyTypes}
      create={CreateEnergyType}
    />
    <Resource
      name="regions"
      list={DisplayRegions}
      show={ShowGuesser}
      edit={EditRegions}
      create={CreateRegion}
    />
    <Resource
      name="streets"
      list={DisplayStreets}
      show={ShowGuesser}
      edit={EditStreets}
      create={CreateStreet}
    />
    <Resource
      name="street_suffices"
      list={DisplaySuffices}
      show={ShowGuesser}
      edit={EditSuffices}
      create={CreateSuffix}
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
      create={CreateCountry}
    />
    
  </Admin>)}

  export default ManagerDashboard;