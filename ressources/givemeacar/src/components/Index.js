import React from 'react';
import LoginForm from './forms/LoginForm';

import RedirectIfSession from './RedirectIfSession';

export default function Index() {

    return <>
        <RedirectIfSession session={true} route='/home' />
        <LoginForm />
    </>
}
