import React from 'react'

import LoginForm from '../forms/LoginForm'
import Home from '../Home'

import Cookies from 'js-cookie'

export default function Signin() {
  return (
      Cookies.get('userStatus') ? <Home /> :<LoginForm />
  )
}
