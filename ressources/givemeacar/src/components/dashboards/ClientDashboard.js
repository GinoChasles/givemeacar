import * as React from "react";

import { frenchMessages } from '../../i18n';

import { Admin, Resource, ListGuesser, ShowGuesser, EditGuesser, useTranslate } from "react-admin";

import polyglotI18nProvider from 'ra-i18n-polyglot';
import jsonServerProvider from "ra-data-json-server"

import MyLayout from '../MyLayout'

import { DisplayRent, EditRent, CreateRent } from "../react-admin/components/rents";
import { DisplayBill, EditBill, CreateBill } from "../react-admin/components/bills";

import redirect from '../../lib/redirectIfNoSession'

const messages = {
  'fr': frenchMessages,
};

const i18nProvider = polyglotI18nProvider(locale => messages[locale]);

i18nProvider.changeLocale('fr');

const dataProvider = jsonServerProvider("http://localhost:8080/api");


const ClientDashboard = () => {

  const t = useTranslate();

  return <>
    { redirect('/')}

    <Admin dataProvider={dataProvider} i18nProvider={i18nProvider}>

      <Resource options={{ label: t("custom.bills") }} name="bills" list={DisplayBill} show={ShowGuesser} edit={EditBill} create={CreateBill} />

      <Resource options={{ label: t("custom.rents") }} name="rents" list={DisplayRent} show={ShowGuesser} edit={EditRent} create={CreateRent} />
    </Admin>
  </>
}

export default ClientDashboard;