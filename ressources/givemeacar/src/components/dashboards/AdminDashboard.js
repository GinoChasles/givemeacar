import * as React from "react";
import {Admin,Resource,ListGuesser,ShowGuesser,EditGuesser} from "react-admin";

import jsonServerProvider from "ra-data-json-server"
import MyLayout from '../MyLayout'
import { CreateAddresses, EditAddresses, DisplayAddresses } from '../react-admin/components/addresses'
import {DisplayAdministrators,CreateAdministrators,EditAdministrators} from "../react-admin/components/administrators";
import {DisplayAgency,EditAgency,CreateAgency} from '../react-admin/components/agency'
import { DisplayBrand,EditBrand,CreateBrand} from "../react-admin/components/brands";
import {DisplayCar,EditCar,CreateCar} from "../react-admin/components/cars";
import {DisplayCity,EditCity,CreateCity} from "../react-admin/components/cities";
import {DisplayClient,EditClient,CreateClient} from "../react-admin/components/clients";
import {DisplayColor,EditColor,CreateColor} from "../react-admin/components/colors";
import {DisplayCountry,CreateCountry,EditCountry} from "../react-admin/components/countries";
import {DisplayDepartment,EditDepartment,CreateDepartment} from "../react-admin/components/departments";
import {DisplayEnergyType,EditEnergyType,CreateEnergyType} from "../react-admin/components/energy_types";
import {DisplayManager,EditManager,CreateManager} from "../react-admin/components/managers";
import {DisplayModel,EditModel,CreateModel} from "../react-admin/components/models";
import {DisplayRegion,EditRegion,CreateRegion} from "../react-admin/components/regions";
import {DisplayRent,EditRent,CreateRent} from "../react-admin/components/rents";
import {DisplayStreetName,EditStreetName,CreateStreetName} from "../react-admin/components/street_names";
import {DisplaySuffix,EditSuffix,CreateSuffix} from "../react-admin/components/street_suffices";
import {DisplayStreet,EditStreet,CreateStreet} from "../react-admin/components/streets";
import {DisplayStatus,EditStatus,CreateStatus} from "../react-admin/components/user_statuses";



const dataProvider = jsonServerProvider("http://localhost:8080/api");

const AdminDashboard = () => {
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
      list={DisplayDepartment}
      show={ShowGuesser}
      edit={EditDepartment}
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
      name="administrators"
      list={DisplayAdministrators}
      show={ShowGuesser}
      edit={EditAdministrators}
      create={CreateAdministrators}
    />
    <Resource
      name="cars"
      list={DisplayCar}
      show={ShowGuesser}
      edit={EditCar}
      create={CreateCar}
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
      list={DisplayModel}
      show={ShowGuesser}
      edit={EditModel}
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
      list={DisplayRent}
      show={ShowGuesser}
      edit={EditRent}
      create={CreateRent}
    />
    <Resource
      name="energy_types"
      list={DisplayEnergyType}
      show={ShowGuesser}
      edit={EditEnergyType}
      create={CreateEnergyType}
    />
    <Resource
      name="regions"
      list={DisplayRegion}
      show={ShowGuesser}
      edit={EditRegion}
      create={CreateRegion}
    />
    <Resource
      name="streets"
      list={DisplayStreet}
      show={ShowGuesser}
      edit={EditStreet}
      create={CreateStreet}
    />
    <Resource
      name="street_suffices"
      list={DisplaySuffix}
      show={ShowGuesser}
      edit={EditSuffix}
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
      list={DisplayCountry}
      show={ShowGuesser}
      edit={EditCountry}
      create={CreateCountry}
    />
    <Resource
      name="user_statuses"
      list={DisplayStatus}
      show={ShowGuesser}
      edit={EditStatus}
      create={CreateStatus}
    />
  </Admin>)}

  export default AdminDashboard;