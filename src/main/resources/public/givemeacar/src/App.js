import * as React from "react";
import { Admin, Resource, ListGuesser,ShowGuesser, EditGuesser } from 'react-admin';
import jsonServerProvider from 'ra-data-json-server';
import users from "./users";
import { PostList, PostEdit, PostCreate } from './components/react-admin/components/post';
const dataProvider = jsonServerProvider('http://localhost:8080/api');

const App = () => (
        <Admin dataProvider= { dataProvider } >
        <Resource name="colors" list={users} show={ ShowGuesser} edit={PostEdit} create={PostCreate} />
        <Resource name="cities" list={ListGuesser} show={ ShowGuesser} edit={EditGuesser} />
        <Resource name="departments" list={ListGuesser} show={ ShowGuesser} edit={EditGuesser} />
        <Resource options={{ label: 'Les managers !' }} name="managers" list={ListGuesser} show={ ShowGuesser} edit={PostEdit} create={PostCreate}/>
        <Resource name="clients" list={users} show={ ShowGuesser} edit={EditGuesser}/>
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