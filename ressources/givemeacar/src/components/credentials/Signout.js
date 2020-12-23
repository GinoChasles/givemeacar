import React from 'react'

import Cookies from 'js-cookie'

import { Redirect } from 'react-router'

export default function Signout() {
    Cookies.remove("userStatus")

    return <Redirect to='/' />
}
