import React from 'react';
import { Redirect } from 'react-router-dom';
import Cookies from 'js-cookie';

import redirect from '../lib/redirectIfSession';

export default function Home() {
  { redirect(false, "/signin") }

  const user = JSON.parse(Cookies.get('user'));

  if (user.authorities) {

    if (user.authorities.includes('ROLE_ADMIN')) {
      return <Redirect to="/dashboard" />
    } else if (user.authorities.includes('ROLE_MANAGER')) {
      return <div>manager</div>
    } else if (user.authorities.includes('ROLE_CLIENT')) {
      return <div>client</div>
    }
    else {
      return <div>visiteur</div>
    }
  }

  return <div>ok</div>
}
