import React from 'react';

function GuestPage() {
  return (
    <div style={{ textAlign: 'center' }}>
      <h2>Welcome, Guest!</h2>
      <p>Here are some flight details:</p>
      <ul style={{ listStyle: 'none' }}>
        <li>Flight: AI202 - Mumbai to Delhi - ₹5,000</li>
        <li>Flight: 6E302 - Bangalore to Kolkata - ₹4,200</li>
        <li>Flight: SG112 - Chennai to Hyderabad - ₹3,800</li>
      </ul>
    </div>
  );
}

export default GuestPage;
