import * as React from "react";
import {Admin,Resource,ListGuesser,ShowGuesser,EditGuesser} from "react-admin";

import jsonServerProvider from "ra-data-json-server"

import {DisplayAgency} from '../react-admin/components/agency/CreateAgency'
import {DisplayManager} from "../react-admin/components/managers/CreateManager.js";
import {DisplayCars} from "../react-admin/components/cars/CreateCar";
import {DisplayClient,EditClient} from "../react-admin/components/clients/CreateClient";
import {DisplayRents,EditRents,CreateRent} from "../react-admin/components/rents/CreateRent";


const dataProvider = jsonServerProvider("http://localhost:8080/api");

const ClientDashboard = () => {
return (
<Admin dataProvider={dataProvider}>

    <Resource
      options={{ label: "Les managers !" }}
      name="managers"
      list={DisplayManager}
      show={ShowGuesser}
    />
    <Resource
      name="clients"
      list={DisplayClient}
      show={ShowGuesser}
      edit={EditClient}
    />
    <Resource
      name="cars"
      list={DisplayCars}
      show={ShowGuesser}
    />
    <Resource
      name="agencies"
      list={DisplayAgency}
      show={ShowGuesser}
    />
    <Resource
      name="bills"
      list={ListGuesser}
      show={ShowGuesser}
      edit={EditGuesser}
    />
    <Resource
      name="rents"
      list={DisplayRents}
      show={ShowGuesser}
      edit={EditRents}
      create={CreateRent}
    />
  </Admin>)}

  export default ClientDashboard;