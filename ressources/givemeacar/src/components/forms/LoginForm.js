import React,{useState,useEffect} from 'react'

import Cookies from 'js-cookie'

export default function LoginForm() {

    const [mail, setMail] = useState()
    const [password, setPassword] = useState()
    
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
                Cookies.set("userStatus", response.headers.get("userStatus"))
                console.log(document.cookie)
                document.location.reload()
            } 
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
