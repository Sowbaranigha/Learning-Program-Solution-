import React from 'react';
import Cart from './Cart';

class OnlineShopping extends React.Component {
  render() {
    const cartItems = [
      { itemname: 'T-Shirt', price: 499 },
      { itemname: 'Jeans', price: 999 },
      { itemname: 'Shoes', price: 1299 },
      { itemname: 'Bag', price: 799 },
      { itemname: 'Watch', price: 1499 }
    ];

    return (
      <div>
        <h1>Online Shopping Cart</h1>
        {cartItems.map((item, index) => (
          <Cart key={index} itemname={item.itemname} price={item.price} />
        ))}
      </div>
    );
  }
}

export default OnlineShopping;
