import * as React from "react";

import { Admin, Resource, ListGuesser, ShowGuesser, EditGuesser, useTranslate } from "react-admin";

import {
  DisplayAdministrators, CreateAdministrators, EditAdministrators, ShowAdministrators
} from "../react-admin/components/administrators";

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
  DisplayClient, EditClient, CreateClient, ShowClient
} from "../react-admin/components/clients";

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
  DisplayManager, EditManager, CreateManager, ShowManager
} from "../react-admin/components/managers";

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
  DisplayStatus, EditStatus, CreateStatus, ShowStatus
} from "../react-admin/components/user_statuses";


import {
  Palette, DirectionsCar, LocationCity, Explore, Streetview, Face,
  AirportShuttle, HomeWork, Receipt, Description, EvStation, Public,
  VpnKey, Person, RecordVoiceOver, FormatListNumbered, Map, LocalShipping, CreditCard
} from '@material-ui/icons';

import redirect from '../../lib/redirectIfNoSession'

const AdminDashboard = ({ dataProvider, i18nProvider }) => {

  const t = useTranslate();

  return <>

    { redirect('/')}

    <Admin dataProvider={dataProvider} i18nProvider={i18nProvider}>
      
      <Resource icon={Face} options={{ label: t("word.clients") }} name="clients"
        list={DisplayClient} show={ShowClient} edit={EditClient} create={CreateClient} />

      <Resource icon={RecordVoiceOver} options={{ label: t("word.managers") }} name="managers"
        list={DisplayManager} show={ShowManager} edit={EditManager} create={CreateManager} />

      <Resource icon={VpnKey} options={{ label: t("word.administrators") }} name="administrators"
        list={DisplayAdministrators} show={ShowAdministrators} edit={EditAdministrators} create={CreateAdministrators} />

      <Resource icon={HomeWork} options={{ label: t("word.agencies") }} name="agencies"
        list={DisplayAgency} show={ShowAgency} edit={EditAgency} create={CreateAgency} />

      <Resource icon={CreditCard} options={{ label: t("word.bills") }} name="bills"
        list={ListGuesser} show={ShowGuesser} edit={EditGuesser} />

      <Resource icon={Description} options={{ label: t("word.rents") }} name="rents"
        list={DisplayRent} show={ShowRent} edit={EditRent} create={CreateRent} />



      <Resource icon={DirectionsCar} options={{ label: t("word.cars") }} name="cars"
        list={DisplayCar} show={ShowCar} edit={EditCar} create={CreateCar} />



      <Resource icon={FormatListNumbered} options={{ label: t("word.suffices") }} name="street_suffices"
        list={DisplaySuffix} show={ShowSuffix} edit={EditSuffix} create={CreateSuffix} />

      <Resource icon={Streetview} options={{ label: t("word.streets") }} name="streets"
        list={DisplayStreet} show={ShowStreet} edit={EditStreet} create={CreateStreet} />

      <Resource icon={LocationCity} options={{ label: t("word.cities") }} name="cities"
        list={DisplayCity} show={ShowCity} edit={EditCity} create={CreateCity} />

      <Resource icon={Explore} options={{ label: t("word.departments") }} name="departments"
        list={DisplayDepartment} show={ShowDepartment} edit={EditDepartment} create={CreateDepartment} />

      <Resource icon={Map} options={{ label: t("word.regions") }} name="regions"
        list={DisplayRegion} show={ShowRegion} edit={EditRegion} create={CreateRegion} />

      <Resource icon={Public} options={{ label: t("word.countries") }} name="countries"
        list={DisplayCountry} show={ShowCountry} edit={EditCountry} create={CreateCountry} />



      <Resource icon={AirportShuttle} options={{ label: t("word.brands") }} name="brands"
        list={DisplayBrand} show={ShowBrand} edit={EditBrand} create={CreateBrand} />

      <Resource icon={LocalShipping} options={{ label: t("word.models") }} name="models"
        list={DisplayModel} show={ShowModel} edit={EditModel} create={CreateModel} />

      <Resource icon={Person} options={{ label: t("word.statuses") }} name="user_statuses"
        list={DisplayStatus} show={ShowStatus} edit={EditStatus} create={CreateStatus} />

      <Resource icon={EvStation} options={{ label: t("word.energyTypes") }} name="energy_types"
        list={DisplayEnergyType} show={ShowEnergyType} edit={EditEnergyType} create={CreateEnergyType} />

      <Resource icon={Palette} options={{ label: t("word.colors") }} name="colors"
        list={DisplayColor} show={ShowColor} edit={EditColor} create={CreateColor} />

    </Admin>
  </>
}

export default AdminDashboard;