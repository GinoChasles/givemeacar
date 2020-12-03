import * as React from "react";
import { Admin, Resource, ListGuesser,ShowGuesser, EditGuesser, Crea } from 'react-admin';
import jsonServerProvider from 'ra-data-json-server';
import usersList from "./usersList";
import managerList from "./components/react-admin/components/managerList";
import { PostEditAgency, PostCreateAgency } from './components/react-admin/components/postAgency';
import { PostEditColor, PostCreateColor } from './components/react-admin/components/testPostColor';
import { PostEditManager, PostCreateManager } from './components/react-admin/components/postManager';
const dataProvider = jsonServerProvider('http://localhost:8080/api');

const App = () => (
        <Admin dataProvider= { dataProvider } >
        <Resource name="colors" list={ListGuesser} show={ ShowGuesser} edit={PostEditColor} create={PostCreateColor} />
        <Resource name="cities" list={ListGuesser} show={ ShowGuesser} edit={EditGuesser} />
        <Resource name="departments" list={ListGuesser} show={ ShowGuesser} edit={EditGuesser} />
<<<<<<< HEAD
=======
        <Resource options={{ label: 'Les managers !' }} name="managers" list={managerList} show={ ShowGuesser} edit={PostEditManager} create={PostCreateManager} />
        <Resource options={{ label: 'créer Les managers !' }} name="managers/create" list={managerList} show={ ShowGuesser} edit={PostEditManager} create={PostCreateManager} />
>>>>>>> 22d9dba3c205c3112c97624391217d2cb5a085d7
        <Resource name="clients" list={usersList} show={ ShowGuesser} edit={EditGuesser}/>
        <Resource options={{ label: 'Les managers !' }} name="managers" list={ListGuesser} show={ ShowGuesser} edit={EditGuesser} />
        <Resource options={{ label: 'Les managers !' }} name="managers/create" list={ListGuesser} show={ ShowGuesser} edit={EditGuesser} />
        <Resource name="cars" list={ListGuesser} show={ ShowGuesser} edit={EditGuesser}/>
        <Resource name="brands" list={ListGuesser} show={ ShowGuesser} edit={EditGuesser}/>
        <Resource name="models" list={ListGuesser} show={ ShowGuesser} edit={EditGuesser}/>
        <Resource name="addresses" list={ListGuesser} show={ ShowGuesser} edit={EditGuesser}/>
        <Resource name="agencies" list={ListGuesser} show={ ShowGuesser} edit={PostEditAgency} create={PostCreateAgency}/>
        <Resource name="bills" list={ListGuesser} show={ ShowGuesser} edit={EditGuesser}/>
        <Resource name="rents" list={ListGuesser} show={ ShowGuesser} edit={EditGuesser}/>
        <Resource name="energy_types" list={ListGuesser} show={ ShowGuesser} edit={EditGuesser}/>
        <Resource name="regions" list={ListGuesser} show={ ShowGuesser} edit={EditGuesser}/>
        <Resource name="streets" list={ListGuesser} show={ ShowGuesser} edit={EditGuesser}/>
        <Resource name="street_suffices" list={ListGuesser} show={ ShowGuesser} edit={EditGuesser}/>
        <Resource name="user_statuses" list={ListGuesser} show={ ShowGuesser} edit={EditGuesser}/>
            </Admin>
);

export default App;