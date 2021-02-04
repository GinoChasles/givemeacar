import * as React from "react";
import AdminDashboard from './AdminDashboard'
import ManagerDashboard from './ManagerDashboard'
import ClientDashboard from './ClientDashboard'

import redirect from '../../lib/redirectIfNoSession'

import Cookies from 'js-cookie'

import { frenchMessages } from '../../i18n';

import jsonServerProvider from "ra-data-json-server"
import polyglotI18nProvider from 'ra-i18n-polyglot';

const messages = {
  'fr': frenchMessages,
};

const dataProvider = jsonServerProvider("http://localhost:8080/api");

const i18nProvider = polyglotI18nProvider(locale => messages[locale]);

i18nProvider.changeLocale('fr');

const PrincipalDashboard = () => {
  
  let dashboard = null;

  const userStatus = parseInt(Cookies.get('userStatus'))
  
  if (typeof userStatus != 'undefined') {
    switch (userStatus) {
      case 1: dashboard = <AdminDashboard dataProvider={dataProvider} i18nProvider={i18nProvider} />; break;
      case 2: dashboard = <ManagerDashboard dataProvider={dataProvider} i18nProvider={i18nProvider} />; break;
      case 3: dashboard = <ClientDashboard dataProvider={dataProvider} i18nProvider={i18nProvider} />; break;
      default: dashboard = null;
    }
  }

  return redirect('/') || dashboard;
  
}

  export default PrincipalDashboard