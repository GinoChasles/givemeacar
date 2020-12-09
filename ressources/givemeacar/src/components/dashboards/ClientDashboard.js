import * as React from "react";
import {Admin,Resource,ListGuesser,ShowGuesser,EditGuesser} from "react-admin";

import jsonServerProvider from "ra-data-json-server"

import {DisplayAgency} from '../react-admin/components/agency/createAgency'
import {DisplayManager} from "../react-admin/components/managers/createManager";
import {DisplayCars} from "../react-admin/components/cars/createCar";
import {DisplayClient,EditClient} from "../react-admin/components/clients/createClients";
import {DisplayRents,EditRents,CreateRents} from "../react-admin/components/rents/createRents";


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
      create={CreateRents}
    />
  </Admin>)}

  export default ClientDashboard;