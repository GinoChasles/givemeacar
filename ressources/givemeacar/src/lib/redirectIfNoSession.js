import React from 'react'
import { Redirect } from 'react-router'

import Cookies from 'js-cookie'

export default function redirectIfNoSession(route) {
    if (!Cookies.get('userStatus')) {
        return <Redirect to={route} />
    }
}
