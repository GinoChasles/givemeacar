import React, { useState, useEffect } from 'react';
import { useHistory } from 'react-router-dom';

import Cookies from 'js-cookie';

import redirect from '../../lib/redirectIfSession';

export default function LoginForm() {


    redirect(true, '/home');

    const history = useHistory();

    const [mail, setMail] = useState();
    const [password, setPassword] = useState();
    
    const handleSubmit = (evt) => {
        evt.preventDefault();

        const form = document.getElementById("login_form")

        const action = form.getAttribute('action')

        const method = form.getAttribute('method')

        var header = new Headers();
        header.append('Content-Type', 'application/json');

        fetch(action, {
            method: method,
            credentials: 'include',
            headers: header,
            mode: 'cors',
            body: JSON.stringify({
                mail: mail,
                password: password
            })  
        }).then((response) => {

            if (response.ok) {
                return response.json()
            } 
            else {
                return Promise.reject(response)
            }
        }).then(json=>{
            Cookies.set('user', JSON.stringify(json));
            history.push('/home');
        }).catch(response => {
            console.log(response);
        })

    }

    const handleMailChange = (evt) => {
        setMail(evt.currentTarget.value)
    }

    const handlePasswordChange = (evt) => {
        setPassword(evt.currentTarget.value)
    }


    return (
        <form id="login_form" action="http://localhost:8080/session/signin" method="POST" onSubmit={handleSubmit}>
            
            <label htmlFor="signin_mail">email</label>
            <input type="text" name="mail" id="signin_mail" value={mail} onChange={handleMailChange}/>

            <label htmlFor="signin_password">password</label>
            <input type="password" name="password" id="signin_password" value={password} onChange={handlePasswordChange}/>

            <button type="submit">signin</button>
        </form>
    )
}
