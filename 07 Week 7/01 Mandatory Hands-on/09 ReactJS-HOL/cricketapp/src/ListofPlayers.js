import React from 'react';

const ListofPlayers = () => {
  const players = [
    { name: "Virat", score: 95 },
    { name: "Rohit", score: 88 },
    { name: "Dhoni", score: 78 },
    { name: "Jadeja", score: 60 },
    { name: "Ashwin", score: 67 },
    { name: "Pant", score: 55 },
    { name: "Bumrah", score: 72 },
    { name: "Surya", score: 91 },
    { name: "Hardik", score: 45 },
    { name: "Gill", score: 82 },
    { name: "Kuldeep", score: 59 }
  ];

  // Use arrow function to filter players with score < 70
  const filtered = players.filter(player => player.score < 70);

  return (
    <div>
      <h2>All Players</h2>
      <ul>
        {players.map((p, index) => (
          <li key={index}>{p.name} - {p.score}</li>
        ))}
      </ul>

      <h3>Players with score below 70</h3>
      <ul>
        {filtered.map((p, index) => (
          <li key={index}>{p.name} - {p.score}</li>
        ))}
      </ul>
    </div>
  );
};

export default ListofPlayers;
