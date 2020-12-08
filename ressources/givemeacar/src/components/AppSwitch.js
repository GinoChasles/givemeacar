import {BrowserRouter as Switch,Route} from "react-router-dom";
import React from "react";


const AppSwitch= ({links}) => links.map((link, i) => <Route exact key={i} path={link.url} component={link.component}></Route>)

export default AppSwitch;