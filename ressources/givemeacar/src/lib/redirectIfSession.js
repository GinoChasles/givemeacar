import React from 'react'
import { Redirect } from 'react-router'

import Cookies from 'js-cookie'

/**
 * Redirige vers la route en fonction de s'il y a une session ou non
 * @param {boolean} session s'il y a session ou non
 * @param {string} route la route de redirection
 */
export default function redirectIfSession(session, route) {
    if (session) {
        if (Cookies.get('user') && Cookies.get('user') !== "undefined") {
            console.log(Cookies.get('user'));
            return <Redirect to={route} />
        }
    } else {
        if (!Cookies.get('user') && !Cookies.get('user') === "undefined") {
            return <Redirect to={route} />
        }
    }
}
