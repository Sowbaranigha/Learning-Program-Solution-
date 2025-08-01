import React from 'react';

function App() {
  const officeSpaces = [
    {
      name: "SpaceHub",
      rent: 55000,
      address: "123 MG Road, Bangalore",
      image: "https://via.placeholder.com/300x200"
    },
    {
      name: "UrbanNest",
      rent: 75000,
      address: "98 Residency Road, Chennai",
      image: "https://via.placeholder.com/300x200"
    },
    {
      name: "SkyView Offices",
      rent: 60000,
      address: "12 Brigade Road, Hyderabad",
      image: "https://via.placeholder.com/300x200"
    }
  ];

  return (
    <div style={{ textAlign: "center", fontFamily: "Arial" }}>
      <h1>Office Space Rental Portal</h1>

      {officeSpaces.map((office, index) => {
        const rentStyle = {
          color: office.rent < 60000 ? "red" : "green",
          fontWeight: "bold"
        };

        return (
          <div
            key={index}
            style={{
              border: "1px solid #ccc",
              padding: "20px",
              margin: "20px auto",
              width: "60%",
              borderRadius: "10px",
              boxShadow: "0px 0px 10px #aaa"
            }}
          >
            <img src={office.image} alt={office.name} style={{ width: "100%", borderRadius: "10px" }} />
            <h2>{office.name}</h2>
            <p><strong>Address:</strong> {office.address}</p>
            <p><strong style={rentStyle}>Rent: ₹{office.rent}</strong></p>
          </div>
        );
      })}
    </div>
  );
}

export default App;
