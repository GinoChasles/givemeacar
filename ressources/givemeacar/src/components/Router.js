import {BrowserRouter as Router} from "react-router-dom";
import AdminDashboard from './dashboards/AdminDashboard'
import NavBar from "./NavBar";
import AppSwitch from "./AppSwitch";

const AppRouter = ({links}) => {
    return (
    <Router>
          <div>
            <NavBar links={links}/>

            <AppSwitch links={links}/>
          </div>
    </Router>
        )
    }

    export default AppRouter;