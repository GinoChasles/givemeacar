import * as React from "react";

import { Admin, Resource, ShowGuesser, useTranslate } from "react-admin";

import { DisplayRent, EditRent, CreateRent } from "../react-admin/components/rents";
//import { DisplayBill, EditBill, CreateBill } from "../react-admin/components/bills";

import redirect from '../../lib/redirectIfNoSession'

const ClientDashboard = ({ dataProvider, i18nProvider }) => {

  const t = useTranslate();

  return <>
    { redirect('/')}

    <Admin dataProvider={dataProvider} i18nProvider={i18nProvider}>

      {/** <Resource options={{ label: t("word.bills") }} name="bills" list={DisplayBill} show={ShowGuesser} edit={EditBill} create={CreateBill} /> */}

      <Resource options={{ label: t("word.rents") }} name="rents" list={DisplayRent} show={ShowGuesser} edit={EditRent} create={CreateRent} />
    </Admin>
  </>
}

export default ClientDashboard;