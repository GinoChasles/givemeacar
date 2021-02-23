import React from 'react'
import { Redirect } from 'react-router'

import Cookies from 'js-cookie'

/**
 * Redirige vers la route en fonction de s'il y a une session ou non
 * @param {boolean} session s'il y a session ou non
 * @param {string} route la route de redirection
 */
export default function RedirectIfSession({ session, route }) {

    if (session && Cookies.get('user')) {
        if (JSON.parse(Cookies.get('user')).authorities) {
            return <Redirect to={route} />
        }
    }
    else if (!session && !Cookies.get('user')) {
        return <Redirect to={route} />
    }

    return null;
}
