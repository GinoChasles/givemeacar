import React from 'react';
import { Redirect } from 'react-router-dom';
import Cookies from 'js-cookie';

export default function Home() {
  const user = JSON.parse(Cookies.get('user'));

  if (user && user.authorities) {

    if (user.authorities.includes('ROLE_ADMIN')) {
      return <Redirect to="/admin" />
    } else if (user.authorities.includes('ROLE_MANAGER')) {
      return <div>manager</div>
    } else if (user.authorities.includes('ROLE_CLIENT')) {
      return <div>client</div>
    }
    else {
      return <div>visiteur</div>
    }
  }

  return <Redirect to='/' />
}
