import React, { useState } from 'react';

function ComplaintRegister() {
  const [name, setName] = useState('');
  const [complaint, setComplaint] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault(); // prevent page refresh

    if (name.trim() === '' || complaint.trim() === '') {
      alert('Please fill in all fields.');
      return;
    }

    const referenceNumber = Math.floor(100000 + Math.random() * 900000);
    alert(
      `Complaint submitted successfully!\n\nEmployee Name: ${name}\nComplaint: ${complaint}\nReference No: ${referenceNumber}`
    );

    // Reset form
    setName('');
    setComplaint('');
  };

  return (
    <div style={{ textAlign: 'center', marginTop: '50px' }}>
      <h2>Raise a Complaint</h2>
      <form onSubmit={handleSubmit} style={{ display: 'inline-block', textAlign: 'left' }}>
        <div>
          <label>Employee Name:</label><br />
          <input
            type="text"
            value={name}
            onChange={(e) => setName(e.target.value)}
            style={{ width: '300px', padding: '8px' }}
          />
        </div>
        <br />
        <div>
          <label>Complaint:</label><br />
          <textarea
            value={complaint}
            onChange={(e) => setComplaint(e.target.value)}
            rows="5"
            cols="40"
            style={{ padding: '8px' }}
          />
        </div>
        <br />
        <button type="submit" style={{ padding: '10px 20px' }}>Submit</button>
      </form>
    </div>
  );
}

export default ComplaintRegister;
