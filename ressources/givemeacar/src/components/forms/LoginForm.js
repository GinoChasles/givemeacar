import React, { useState } from 'react';
import { useHistory } from 'react-router-dom';

import {
    Avatar, Button, CssBaseline,
    TextField,
    FormControlLabel,
    Checkbox,
    Link,
    Grid,
    Typography,
    Container
} from '@material-ui/core'

import LockOutlinedIcon from '@material-ui/icons/LockOutlined';
import { makeStyles } from '@material-ui/core/styles';

import Cookies from 'js-cookie';

const useStyles = makeStyles((theme) => ({
    paper: {
        marginTop: theme.spacing(8),
        display: 'flex',
        flexDirection: 'column',
        alignItems: 'center',
    },
    avatar: {
        margin: theme.spacing(1),
        backgroundColor: theme.palette.secondary.main,
    },
    form: {
        width: '100%', // Fix IE 11 issue.
        marginTop: theme.spacing(1),
    },
    submit: {
        margin: theme.spacing(3, 0, 2),
    },
}));

export default function LoginForm() {
    const classes = useStyles();

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
        }).then(json => {
            console.log((1 / 3600) / 12);

            Cookies.set('user', JSON.stringify(json), { expires: 1 });

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
        <Container component="main" maxWidth="xs">
            <CssBaseline />
            <div className={classes.paper}>
                <Avatar className={classes.avatar}>
                    <LockOutlinedIcon />
                </Avatar>
                <Typography component="h1" variant="h5">
                    Sign in
                </Typography>
                <form className={classes.form} noValidate id="login_form" action="http://localhost:8080/session/signin" method="POST" onSubmit={handleSubmit}>
                    <TextField
                        variant="outlined"
                        margin="normal"
                        required
                        fullWidth
                        id="email"
                        label="Email Address"
                        name="email"
                        autoComplete="email"
                        autoFocus

                        onChange={handleMailChange}
                    />
                    <TextField
                        variant="outlined"
                        margin="normal"
                        required
                        fullWidth
                        name="password"
                        label="Password"
                        type="password"
                        id="password"
                        autoComplete="current-password"

                        onChange={handlePasswordChange}
                    />

                    <FormControlLabel
                        control={<Checkbox value="remember" color="primary" />}
                        label="Remember me"
                    />
                    
                    <Button
                        type="submit"
                        fullWidth
                        variant="contained"
                        color="primary"
                        className={classes.submit}
                    >
                        Sign In
          </Button>
                    <Grid container>
                        <Grid item xs>
                            <Link href="#" variant="body2">
                                Forgot password?
              </Link>
                        </Grid>
                        <Grid item>
                            <Link href="#" variant="body2">
                                {"Don't have an account? Sign Up"}
                            </Link>
                        </Grid>
                    </Grid>
                </form>
            </div>
        </Container>
    );
}
