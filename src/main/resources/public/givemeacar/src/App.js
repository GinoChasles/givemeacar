import './App.css';
import * as React from "react";
import { useState } from 'react';
import FormManager from "./components/FormManager";
import ManagerCard from "./components/ManagerCard";
import { Admin, Resource } from 'react-admin';
import { UserList } from './users';
import jsonServerProvider from 'ra-data-json-server';

const dataProvider = jsonServerProvider('https://jsonplaceholder.typicode.com');
const manager = jsonServerProvider('http://localhost:8080/api');

const App = () => (
  <div>
      <Admin dataProvider={dataProvider}>
          <Resource name="users" list={UserList} />
      </Admin>
      <Admin dataProvider={manager}>
          <Resource name="managers" list={UserList} />
      </Admin>
      </div>
);

export default App;




// function App() {

//   const [manager, setManager] = useState({
//     lastName: "",
//     firstName: "",
//     mail: "",
//     password: "",
//     phone: "",
//   });

//   return (
//     <div>
//     <FormManager onSubmit={setManager} />
//     <ManagerCard manager={manager} />
//     </div>
  

//   );
// }

// export default App;
