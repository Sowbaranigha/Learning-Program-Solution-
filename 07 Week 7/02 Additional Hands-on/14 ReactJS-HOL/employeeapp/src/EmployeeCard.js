import React, { useContext } from 'react';
import ThemeContext from './ThemeContext';

function EmployeeCard({ name, role }) {
  const theme = useContext(ThemeContext); // Get theme from context

  return (
    <div className={`card ${theme}`}>
      <h3>{name}</h3>
      <p>{role}</p>
      <button className={theme}>Details</button>
    </div>
  );
}

export default EmployeeCard;
