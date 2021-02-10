import * as React from "react";


import { Admin, Resource, ListGuesser, ShowGuesser, EditGuesser, useTranslate } from "react-admin";

import { DisplayClient, EditClient, CreateClient } from "../react-admin/components/clients";
import { DisplayRent, EditRent, CreateRent } from "../react-admin/components/rents";
import { DisplayStatus, EditStatus, CreateStatus } from "../react-admin/components/user_statuses";

import redirect from '../../lib/redirectIfNoSession'

const ManagerDashboard = ({ dataProvider, i18nProvider }) => {

  const t = useTranslate();

  return <>

    { redirect('/')}

    <Admin dataProvider={dataProvider} i18nProvider={i18nProvider}>

      <Resource options={{ label: t("word.clients") }} name="clients" list={DisplayClient} show={ShowGuesser} edit={EditClient} create={CreateClient} />

      <Resource options={{ label: t("word.bills") }} name="bills" list={ListGuesser} show={ShowGuesser} edit={EditGuesser} />

      <Resource options={{ label: t("word.rents") }} name="rents" list={DisplayRent} show={ShowGuesser} edit={EditRent} create={CreateRent} />

      <Resource options={{ label: t("word.statuses") }} name="user_statuses" list={DisplayStatus} show={ShowGuesser} edit={EditStatus} create={CreateStatus} />
    </Admin>
  </>
}

export default ManagerDashboard;