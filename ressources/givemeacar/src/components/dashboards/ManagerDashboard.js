import * as React from "react";
import {Admin,Resource,ListGuesser,ShowGuesser,EditGuesser} from "react-admin";

import jsonServerProvider from "ra-data-json-server"

import {DisplayColor,EditColor,CreateColor} from "../react-admin/components/colors";
import {DisplayCity,EditCity,CreateCity} from "../react-admin/components/cities";
import { DisplayBrand,EditBrand,CreateBrand} from "../react-admin/components/brands";
import { CreateAddresses, EditAddresses, DisplayAddresses } from '../react-admin/components/addresses'
import {DisplayManager,EditManager,CreateManager} from "../react-admin/components/managers";
import {DisplayCountry,CreateCountry,EditCountry} from "../react-admin/components/countries";
import {DisplayCar,EditCar,CreateCar} from "../react-admin/components/cars";
import {DisplayClient,EditClient,CreateClient} from "../react-admin/components/clients";
import {DisplayDepartment,EditDepartment,CreateDepartment,} from "../react-admin/components/departments";
import {DisplayEnergyType,EditEnergyType,CreateEnergyType} from "../react-admin/components/energy_types";
import {DisplayModel,EditModel,CreateModel} from "../react-admin/components/models";
import {DisplayRegion,EditRegion,CreateRegion} from "../react-admin/components/regions";
import {DisplayRent,EditRent,CreateRent} from "../react-admin/components/rents";
import {DisplayStreet,EditStreet,CreateStreet} from "../react-admin/components/streets";
import {DisplaySuffix,EditSuffix,CreateSuffix} from "../react-admin/components/street_suffices";
import MyLayout from "../MyLayout";

const dataProvider = jsonServerProvider("http://localhost:8080/api");

import redirect from '../../lib/redirectIfNoSession'

const ManagerDashboard = () => <>
  { redirect('/')}

  <Admin dataProvider={dataProvider} layout={MyLayout}>
    <Resource options={{ label: "Les couleurs" }} name="colors" list={DisplayColor} edit={EditColor} create={CreateColor} />
    <Resource name="cities" list={DisplayCity} show={ShowGuesser} edit={EditCity} create={CreateCity} />
    <Resource name="departments" list={DisplayDepartment} show={ShowGuesser} edit={EditDepartment} create={CreateDepartment} />
    <Resource options={{ label: "Les managers !" }} name="managers" list={DisplayManager} show={ShowGuesser} edit={EditManager} create={CreateManager} />
    <Resource name="clients" list={DisplayClient} show={ShowGuesser} edit={EditClient} create={CreateClient} />
    <Resource name="cars" list={DisplayCar} show={ShowGuesser} edit={EditCar} create={CreateCar} />
    <Resource name="brands" options={{ label: "Constructeurs" }} list={DisplayBrand} show={ShowGuesser} edit={EditBrand} create={CreateBrand} />
    <Resource name="models" list={DisplayModel} show={ShowGuesser} edit={EditModel} create={CreateModel} />
    <Resource name="addresses" list={DisplayAddresses} show={ShowGuesser} edit={EditAddresses} create={CreateAddresses} />
    <Resource name="bills" list={ListGuesser} show={ShowGuesser} edit={EditGuesser} />
    <Resource name="rents" list={DisplayRent} show={ShowGuesser} edit={EditRent} create={CreateRent} />
    <Resource name="energy_types" list={DisplayEnergyType} show={ShowGuesser} edit={EditEnergyType} create={CreateEnergyType} />
    <Resource name="regions" list={DisplayRegion} show={ShowGuesser} edit={EditRegion} create={CreateRegion} />
    <Resource name="street_suffices" list={DisplaySuffix} show={ShowGuesser} edit={EditSuffix} create={CreateSuffix} />
    <Resource name="streets" list={DisplayStreet} show={ShowGuesser} edit={EditStreet} create={CreateStreet} />
    <Resource name="countries" list={DisplayCountry} show={ShowGuesser} edit={EditCountry} create={CreateCountry} />
    <Resource name="user_statuses" list={DisplayStatus} show={ShowGuesser} edit={EditStatus} create={CreateStatus} />
  </Admin>
</>

export default ManagerDashboard;