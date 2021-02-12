import React from 'react';
import { Redirect } from 'react-router-dom';
import Cookies from 'js-cookie';

import redirect from '../lib/redirectIfSession';

export default function Home() {
  { redirect(false, "/signin") }

  const user = JSON.parse(Cookies.get('user'));

  if (user.roles) {

    if (user.roles.includes('admin')) {
      return <Redirect to="/dashboard" />
    } else if (user.roles.includes('manager')) {
      return <div>manager</div>
    } else if (user.roles.includes('client')) {
      return <div>client</div>
    }
    else {
      return <div>visiteur</div>
    }
  }

  return <div>ok</div>
}
