import logo from './logo.svg';
import './App.css';

import { useState } from 'react';

function App() {
  const [id, setId] = useState();

  return (
    <form  method="get" >
      
      <input type="number" name="id" defaultValue={id} onChange={(e) => {
        setId(e.currentTarget.value);
      }} />

      <button type="submit" onClick={(e) => {
        e.preventDefault();
        
        fetch('http://localhost:8080/api/cars/' + id).then(res => {
          if (res.ok) {
            return res.text();
          }
        }).then(text=>console.log(text))
      }}>valider</button>

    </form>
  );
}

export default App;
