import * as React from "react";

import { Admin, Resource, ListGuesser, ShowGuesser, EditGuesser, useTranslate } from "react-admin";

import { DisplayAdministrators, CreateAdministrators, EditAdministrators } from "../react-admin/components/administrators";
import {DisplayAgency,EditAgency,CreateAgency} from '../react-admin/components/agency'
import { DisplayBrand, EditBrand, CreateBrand } from "../react-admin/components/brands";
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
import {DisplayStreet,EditStreet,CreateStreet} from "../react-admin/components/streets";
import {DisplaySuffix,EditSuffix,CreateSuffix} from "../react-admin/components/street_suffices";
import {DisplayStatus,EditStatus,CreateStatus} from "../react-admin/components/user_statuses";

import redirect from '../../lib/redirectIfNoSession'

const AdminDashboard = ({ dataProvider, i18nProvider }) => {

  const t = useTranslate();

  return <>


    { redirect('/')}

    <Admin dataProvider={dataProvider} i18nProvider={i18nProvider}>

      <Resource options={{ label: t("custom.colors") }} name="colors" list={DisplayColor} edit={EditColor} create={CreateColor} />

      <Resource options={{ label: t("custom.cities") }} name="cities" list={DisplayCity} show={ShowGuesser} edit={EditCity} create={CreateCity} />

      <Resource options={{ label: t("custom.departments") }} name="departments" list={DisplayDepartment} show={ShowGuesser} edit={EditDepartment} create={CreateDepartment} />

      <Resource options={{ label: t("custom.managers") }} name="managers" list={DisplayManager} show={ShowGuesser} edit={EditManager} create={CreateManager} />

      <Resource options={{ label: t("custom.clients") }} name="clients" list={DisplayClient} show={ShowGuesser} edit={EditClient} create={CreateClient} />

      <Resource options={{ label: t("custom.administrators") }} name="administrators" list={DisplayAdministrators} show={ShowGuesser} edit={EditAdministrators} create={CreateAdministrators} />

      <Resource options={{ label: t("custom.cars") }} name="cars" list={DisplayCar} show={ShowGuesser} edit={EditCar} create={CreateCar} />

      <Resource options={{ label: t("custom.brands") }} name="brands" options={{ label: "Constructeurs" }} list={DisplayBrand} show={ShowGuesser} edit={EditBrand} create={CreateBrand} />

      <Resource options={{ label: t("custom.models") }} name="models" list={DisplayModel} show={ShowGuesser} edit={EditModel} create={CreateModel} />

      <Resource options={{ label: t("custom.agencies") }} name="agencies" list={DisplayAgency} show={ShowGuesser} edit={EditAgency} create={CreateAgency} />

      <Resource options={{ label: t("custom.bills") }} name="bills" list={ListGuesser} show={ShowGuesser} edit={EditGuesser} />

      <Resource options={{ label: t("custom.rents") }} name="rents" list={DisplayRent} show={ShowGuesser} edit={EditRent} create={CreateRent} />

      <Resource options={{ label: t("custom.energyTypes") }} name="energy_types" list={DisplayEnergyType} show={ShowGuesser} edit={EditEnergyType} create={CreateEnergyType} />

      <Resource options={{ label: t("custom.regions") }} name="regions" list={DisplayRegion} show={ShowGuesser} edit={EditRegion} create={CreateRegion} />

      <Resource options={{ label: t("custom.suffices") }} name="street_suffices" list={DisplaySuffix} show={ShowGuesser} edit={EditSuffix} create={CreateSuffix} />

      <Resource options={{ label: t("custom.streets") }} name="streets" list={DisplayStreet} show={ShowGuesser} edit={EditStreet} create={CreateStreet} />

      <Resource options={{ label: t("custom.countries") }} name="countries" list={DisplayCountry} show={ShowGuesser} edit={EditCountry} create={CreateCountry} />

      <Resource options={{ label: t("custom.statuses") }} name="user_statuses" list={DisplayStatus} show={ShowGuesser} edit={EditStatus} create={CreateStatus} />
    </Admin>
  </>
}

export default AdminDashboard;