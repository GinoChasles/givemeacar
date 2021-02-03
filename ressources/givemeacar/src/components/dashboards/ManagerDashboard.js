import * as React from "react";

import { frenchMessages } from '../../i18n';

import { Admin, Resource, ListGuesser, ShowGuesser, EditGuesser, useTranslate } from "react-admin";

import polyglotI18nProvider from 'ra-i18n-polyglot';
import jsonServerProvider from "ra-data-json-server"


import MyLayout from '../MyLayout'

import { DisplayClient, EditClient, CreateClient } from "../react-admin/components/clients";
import { DisplayRent, EditRent, CreateRent } from "../react-admin/components/rents";
import { DisplayStatus, EditStatus, CreateStatus } from "../react-admin/components/user_statuses";

import redirect from '../../lib/redirectIfNoSession'

const messages = {
  'fr': frenchMessages,
};

const i18nProvider = polyglotI18nProvider(locale => messages[locale]);

i18nProvider.changeLocale('fr');

const dataProvider = jsonServerProvider("http://localhost:8080/api");


const ManagerDashboard = () => {

  const t = useTranslate();

  return <>


    { redirect('/')}

    <Admin dataProvider={dataProvider} i18nProvider={i18nProvider}>

      <Resource options={{ label: t("custom.clients") }} name="clients" list={DisplayClient} show={ShowGuesser} edit={EditClient} create={CreateClient} />

      <Resource options={{ label: t("custom.bills") }} name="bills" list={ListGuesser} show={ShowGuesser} edit={EditGuesser} />

      <Resource options={{ label: t("custom.rents") }} name="rents" list={DisplayRent} show={ShowGuesser} edit={EditRent} create={CreateRent} />

      <Resource options={{ label: t("custom.statuses") }} name="user_statuses" list={DisplayStatus} show={ShowGuesser} edit={EditStatus} create={CreateStatus} />
    </Admin>
  </>
}

export default ManagerDashboard;