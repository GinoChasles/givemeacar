import * as React from "react";
import { Admin, Resource, ListGuesser,ShowGuesser, EditGuesser } from 'react-admin';
import jsonServerProvider from 'ra-data-json-server';
import users from "./users";

const dataProvider = jsonServerProvider('http://localhost:8080/api');

const App = () => (
        <Admin dataProvider= { dataProvider } >
        <Resource name="colors" list={ListGuesser} show={ ShowGuesser} edit={EditGuesser} />
        <Resource name="cities" list={users} show={ ShowGuesser} edit={EditGuesser}/>
        <Resource name="departments" list={ListGuesser} show={ ShowGuesser} edit={EditGuesser} />
        <Resource options={{ label: 'Doing' }} name="managers" list={ListGuesser} show={ ShowGuesser} edit={EditGuesser}/>
        <Resource name="clients" list={ListGuesser} show={ ShowGuesser} edit={EditGuesser}/>
        <Resource name="cars" list={ListGuesser} show={ ShowGuesser} edit={EditGuesser}/>
        <Resource name="brands" list={ListGuesser} show={ ShowGuesser} edit={EditGuesser}/>
        <Resource name="models" list={ListGuesser} show={ ShowGuesser} edit={EditGuesser}/>
        <Resource name="addresses" list={ListGuesser} show={ ShowGuesser} edit={EditGuesser}/>
        <Resource name="administrators" list={ListGuesser} show={ ShowGuesser} edit={EditGuesser}/>
        <Resource name="agencies" list={ListGuesser} show={ ShowGuesser} edit={EditGuesser}/>
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