import {BrowserRouter as Router,Switch} from "react-router-dom";
import NavBar from "./NavBar";
import AppSwitch from "./AppSwitch";

import React from 'react'

const AppRouter = ({links}) => <Router>
            <NavBar links={links}/>
            <Switch><AppSwitch links={links}/></Switch>
        </Router>

export default AppRouter;