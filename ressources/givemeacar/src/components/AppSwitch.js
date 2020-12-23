import {BrowserRouter as Switch,Route} from "react-router-dom";
import React from "react";

import Home from './Home';
import Signin from './credentials/Signin'
import ForgotPassword from './credentials/ForgotPassword'
import Signup from './credentials/Signup'
import Bills from './rental/Bills'
import Current from './rental/Current'
import Search from './rental/Search'
import Rent from './rental/Rent'
import Map from './map/Map'
import PrincipalDashboard from './dashboards/PrincipalDashboard'

const links = [
    { url: '/home', label: 'Home', component: Home },
    { url: '/dashboard', label: 'Dashboard', component: PrincipalDashboard },
    { url: '/signin', label: 'connexion', component: Signin },
    { url: '/signup', label: 's\'enregistrer', component: Signup },
    { url: '/forgot-password', label: 'Mot de passe oublié', component: ForgotPassword },
    { url: '/map', label: 'carte', component: Map },
    { url: '/rent', label: 'Louer', component: Rent },
    { url: '/search', label: 'Recherche un véhicule', component: Search },
    { url: '/bills', label: 'Factures', component: Bills },
    { url: '/current', label: 'Location en cours', component: Current }
]

const AppSwitch= ({links}) => links.map((link, i) => <Route exact key={i} path={link.url} component={link.component}></Route>)

export default AppSwitch;