import * as React from "react";

import { Admin, Resource, ListGuesser, ShowGuesser, EditGuesser, useTranslate } from "react-admin";

import {
  DisplayUsers, CreateUsers, EditUsers, ShowUsers
} from "../react-admin/components/users";

import {
  DisplayAgency, EditAgency, CreateAgency, ShowAgency
} from '../react-admin/components/agency'

import {
  DisplayBrand, EditBrand, CreateBrand, ShowBrand
} from "../react-admin/components/brands";

import {
  DisplayCar, EditCar, CreateCar, ShowCar
} from "../react-admin/components/cars";

import {
  DisplayCity, EditCity, CreateCity, ShowCity
} from "../react-admin/components/cities";

import {
  DisplayColor, EditColor, CreateColor, ShowColor
} from "../react-admin/components/colors";

import {
  DisplayCountry, CreateCountry, EditCountry, ShowCountry
} from "../react-admin/components/countries";

import {
  DisplayDepartment, EditDepartment, CreateDepartment, ShowDepartment
} from "../react-admin/components/departments";

import {
  DisplayEnergyType, EditEnergyType, CreateEnergyType, ShowEnergyType
} from "../react-admin/components/energy_types";

import {
  DisplayModel, EditModel, CreateModel, ShowModel
} from "../react-admin/components/models";

import {
  DisplayRegion, EditRegion, CreateRegion, ShowRegion
} from "../react-admin/components/regions";

import {
  DisplayRent, EditRent, CreateRent, ShowRent
} from "../react-admin/components/rents";

import {
  DisplayStreet, EditStreet, CreateStreet, ShowStreet
} from "../react-admin/components/streets";

import {
  DisplaySuffix, EditSuffix, CreateSuffix, ShowSuffix
} from "../react-admin/components/street_suffices";

import {
  DisplayRole, EditRole, CreateRole, ShowRole
} from "../react-admin/components/roles";



import {
  Palette, DirectionsCar, LocationCity, Explore, Streetview, Face,
  AirportShuttle, HomeWork, Receipt, Description, EvStation, Public,
  VpnKey, Person, RecordVoiceOver, FormatListNumbered, Map, LocalShipping
} from '@material-ui/icons';

import redirect from '../../lib/redirectIfNoSession'

const AdminDashboard = ({ dataProvider, i18nProvider }) => {

  const t = useTranslate();

  return <>

    { redirect('/')}

    <Admin dataProvider={dataProvider} i18nProvider={i18nProvider}>
      
      <Resource icon={Face} options={{ label: t("custom.clients") }} name="clients"
        list={DisplayUser} show={ShowUser} edit={EditUser} create={CreateUser} />

      <Resource icon={HomeWork} options={{ label: t("custom.agencies") }} name="agencies"
        list={DisplayAgency} show={ShowAgency} edit={EditAgency} create={CreateAgency} />

      <Resource icon={Receipt} options={{ label: t("custom.bills") }} name="bills"
        list={ListGuesser} show={ShowGuesser} edit={EditGuesser} />

      <Resource icon={Description} options={{ label: t("custom.rents") }} name="rents"
        list={DisplayRent} show={ShowRent} edit={EditRent} create={CreateRent} />



      <Resource icon={DirectionsCar} options={{ label: t("custom.cars") }} name="cars"
        list={DisplayCar} show={ShowCar} edit={EditCar} create={CreateCar} />



      <Resource icon={FormatListNumbered} options={{ label: t("custom.suffices") }} name="street_suffices"
        list={DisplaySuffix} show={ShowSuffix} edit={EditSuffix} create={CreateSuffix} />

      <Resource icon={Streetview} options={{ label: t("custom.streets") }} name="streets"
        list={DisplayStreet} show={ShowStreet} edit={EditStreet} create={CreateStreet} />

      <Resource icon={LocationCity} options={{ label: t("custom.cities") }} name="cities"
        list={DisplayCity} show={ShowCity} edit={EditCity} create={CreateCity} />

      <Resource icon={Explore} options={{ label: t("custom.departments") }} name="departments"
        list={DisplayDepartment} show={ShowDepartment} edit={EditDepartment} create={CreateDepartment} />

      <Resource icon={Map} options={{ label: t("custom.regions") }} name="regions"
        list={DisplayRegion} show={ShowRegion} edit={EditRegion} create={CreateRegion} />

      <Resource icon={Public} options={{ label: t("custom.countries") }} name="countries"
        list={DisplayCountry} show={ShowCountry} edit={EditCountry} create={CreateCountry} />



      <Resource icon={AirportShuttle} options={{ label: t("custom.brands") }} name="brands"
        list={DisplayBrand} show={ShowBrand} edit={EditBrand} create={CreateBrand} />

      <Resource icon={LocalShipping} options={{ label: t("custom.models") }} name="models"
        list={DisplayModel} show={ShowModel} edit={EditModel} create={CreateModel} />

      <Resource icon={Person} options={{ label: t("custom.statuses") }} name="user_statuses"
        list={DisplayStatus} show={ShowStatus} edit={EditStatus} create={CreateStatus} />

      <Resource icon={EvStation} options={{ label: t("custom.energyTypes") }} name="energy_types"
        list={DisplayEnergyType} show={ShowEnergyType} edit={EditEnergyType} create={CreateEnergyType} />

      <Resource icon={Palette} options={{ label: t("custom.colors") }} name="colors"
        list={DisplayColor} show={ShowColor} edit={EditColor} create={CreateColor} />

    </Admin>
  </>
}

export default AdminDashboard;