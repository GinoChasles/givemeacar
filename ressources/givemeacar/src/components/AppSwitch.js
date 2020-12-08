import {BrowserRouter as Switch,Route} from "react-router-dom";


const AppSwitch= ({links}) => <Switch>{links.map((link,i)=><Route key={i} path={link.url}>{link.component}</Route>)}</Switch>

    export default AppSwitch;