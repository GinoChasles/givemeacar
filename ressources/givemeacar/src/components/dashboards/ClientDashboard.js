import * as React from "react";
import {Admin,Resource,ListGuesser,ShowGuesser,EditGuesser} from "react-admin";

import jsonServerProvider from "ra-data-json-server"

import MyLayout from '../MyLayout'
import {DisplayAgency} from '../react-admin/components/agency'
import {DisplayCar} from '../react-admin/components/cars'
import {DisplayClient,EditClient,CreateClient} from "../react-admin/components/clients";
import {DisplayManager} from "../react-admin/components/managers";
import {CreateRent, DisplayRent, EditRent} from "../react-admin/components/rents";

import redirect from '../../lib/redirectIfNoSession'

const dataProvider = jsonServerProvider("http://localhost:8080/api");

const ClientDashboard = () => <>
    { redirect('/')}

    <Admin dataProvider={dataProvider} layout={MyLayout}>
      <Resource options={{ label: "Les managers !" }} name="managers" list={DisplayManager} show={ShowGuesser} />
      <Resource name="clients" list={DisplayClient} show={ShowGuesser} edit={EditClient} />
      <Resource name="cars" list={DisplayCar} show={ShowGuesser} />
      <Resource name="agencies" list={DisplayAgency} show={ShowGuesser} />
      <Resource name="bills" list={ListGuesser} show={ShowGuesser} edit={EditGuesser} />
      <Resource name="rents" list={DisplayRent} show={ShowGuesser} edit={EditRent} create={CreateRent} />
      </Admin>
    </>

  export default ClientDashboard;