import React from 'react';
import CohortDetails from './CohortDetails';

function App() {
  return (
    <div className="App">
      <h1>My Academy Cohort Dashboard</h1>

      <CohortDetails 
        name="React Cohort 1" 
        status="ongoing" 
        startDate="2025-06-01" 
        endDate="2025-08-01" 
      />

      <CohortDetails 
        name="Angular Cohort 2" 
        status="completed" 
        startDate="2025-03-01" 
        endDate="2025-05-01" 
      />
    </div>
  );
}

export default App;
