import Home from '../components/Home';
import Signin from '../components/credentials/Signin';
import Signout from '../components/credentials/Signout';
import ForgotPassword from '../components/credentials/ForgotPassword'
import Signup from '../components/credentials/Signup'
import Bills from '../components/rental/Bills'
import Current from '../components/rental/Current'
import Search from '../components/rental/Search'
import Rent from '../components/rental/Rent'
import Map from '../components/map/Map'
import PrincipalDashboard from '../components/dashboards/PrincipalDashboard'

const links = [
{url:'/',label:'signin',component:Signin},
{url:'/home',label:'Home',component:Home},
{url:'/dashboard',label:'Dashboard',component:PrincipalDashboard},
{url:'/signin',label:'connexion',component:Signin},
{url:'/signup',label:'s\'enregistrer',component:Signup},
{url:'/forgot-password',label:'Mot de passe oublié',component:ForgotPassword},
{url:'/map',label:'carte',component:Map},
{url:'/rent',label:'Louer',component:Rent},
{url:'/search',label:'Recherche un véhicule',component:Search},
{url:'/bills',label:'Factures',component:Bills},
{url:'/current',label:'Location en cours',component:Current},
{url:'/signout',label:'signout',component:Signout},
]

export default links