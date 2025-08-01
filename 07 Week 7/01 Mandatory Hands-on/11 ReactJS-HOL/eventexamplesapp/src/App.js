import React from 'react';
import CurrencyConvertor from './CurrencyConvertor';

class App extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      count: 0
    };
  }

  increment = () => {
    this.setState({ count: this.state.count + 1 });
    this.sayHello();
  }

  decrement = () => {
    this.setState({ count: this.state.count - 1 });
  }

  sayHello = () => {
    console.log("Hello from Increment Button!");
    alert("Hello! Counter was increased.");
  }

  sayWelcome = (msg) => {
    alert(`Message: ${msg}`);
  }

  handleSyntheticEvent = (e) => {
    e.preventDefault();
    alert("I was clicked (Synthetic Event)");
  }

  render() {
    return (
      <div style={{ textAlign: 'center', marginTop: '40px' }}>
        <h1>React Event Examples</h1>

        <h2>Counter: {this.state.count}</h2>
        <button onClick={this.increment}>Increment</button>{' '}
        <button onClick={this.decrement}>Decrement</button>

        <br /><br />
        <button onClick={() => this.sayWelcome("Welcome to the app!")}>Say Welcome</button>

        <br /><br />
        <button onClick={this.handleSyntheticEvent}>OnPress (Synthetic Event)</button>

        <br /><br />
        <CurrencyConvertor />
      </div>
    );
  }
}

export default App;
