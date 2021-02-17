import * as React from "react";
import AdminDashboard from './AdminDashboard';
import { Redirect } from 'react-router-dom';
import redirect from '../../lib/redirectIfSession';

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

  redirect(false, '/signin');

  const authorities = JSON.parse(Cookies.get('user')).authorities;

  if (authorities) {
    if (authorities.includes('ROLE_ADMIN')) {
      return <AdminDashboard dataProvider={dataProvider} i18nProvider={i18nProvider} />
    }
    else if (authorities.includes('ROLE_MANAGER')) {
      return <div>manager</div>
    }
  }

  return <Redirect to="/signin" />
  
}

  export default PrincipalDashboard