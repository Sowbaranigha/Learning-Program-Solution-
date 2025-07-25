import React from 'react';

class Cart extends React.Component {
  render() {
    return (
      <div style={{ border: "1px solid gray", padding: "10px", margin: "10px", width: "200px" }}>
        <h3>{this.props.itemname}</h3>
        <p>Price: ₹{this.props.price}</p>
      </div>
    );
  }
}

export default Cart;
