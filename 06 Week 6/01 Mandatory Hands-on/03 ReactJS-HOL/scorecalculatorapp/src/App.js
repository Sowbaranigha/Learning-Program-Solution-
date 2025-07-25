import React from 'react';
import CalculateScore from './Components/CalculateScore';
import './Stylesheets/mystyle.css';

function App() {
  return (
    <div className="App">
      <h1>Student Score Calculator</h1>
      <CalculateScore name="Sowbaghya" school="ABC School" total={450} goal={5} />
    </div>
  );
}

export default App;
