import * as React from "react";
import AdminDashboard from './AdminDashboard'

import redirect from '../../lib/redirectIfNoSession'

import Cookies from 'js-cookie'

const PrincipalDashboard = () => {
  
  let dashboard = null;

  const userStatus = parseInt(Cookies.get('userStatus'))
  
  if (typeof userStatus != 'undefined') {
    switch (userStatus) {
      case 1: dashboard = <AdminDashboard />; break;
      case 2: dashboard = <AdminDashboard />; break;
      case 3: dashboard =  <AdminDashboard />; break;
      default: dashboard = null;
    }
  }

  return redirect('/') || dashboard;
  
}

  export default PrincipalDashboard