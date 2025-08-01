import React from 'react';

const IndianPlayers = () => {
  // Destructuring and merging arrays
  const T20 = ['Virat', 'Rohit', 'Pant', 'Surya', 'Hardik'];
  const Ranji = ['Pujara', 'Rahane', 'Saha', 'Umesh', 'Ishant'];

  const allPlayers = [...T20, ...Ranji];

  const oddPlayers = allPlayers.filter((player, index) => index % 2 === 1);
  const evenPlayers = allPlayers.filter((player, index) => index % 2 === 0);

  return (
    <div>
      <h2>Merged Players</h2>
      <p>{allPlayers.join(', ')}</p>

      <h3>Odd Team Players</h3>
      <ul>
        {oddPlayers.map((p, index) => <li key={index}>{p}</li>)}
      </ul>

      <h3>Even Team Players</h3>
      <ul>
        {evenPlayers.map((p, index) => <li key={index}>{p}</li>)}
      </ul>
    </div>
  );
};

export default IndianPlayers;
