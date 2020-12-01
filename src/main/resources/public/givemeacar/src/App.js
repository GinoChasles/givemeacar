import './App.css';

import { useState } from 'react';
import FormManager from "./components/FormManager";
import ManagerCard from "./components/ManagerCard";


function App() {
  // const [id, setId] = useState();
  const [manager, setManager] = useState({
    lastName: "",
    firstName: "",
    mail: "",
    password: "",
    phone: "",
  });

  return (
    <div>
    <FormManager onSubmit={setManager} />
    <ManagerCard manager={manager} />
    </div>
    // <form  method="get" >

    //   <input type="number" name="id" defaultValue={id} onChange={(e) => {
    //     setId(e.currentTarget.value);
    //   }} />

    //   <button type="submit" onClick={(e) => {
    //     e.preventDefault();

    //     fetch('http://localhost:8080/api/cars/' + id).then(res => {
    //       if (res.ok) {
    //         return res.text();
    //       }
    //     }).then(text=>console.log(text))
    //   }}>valider</button>

    // </form>
  );
}

export default App;
