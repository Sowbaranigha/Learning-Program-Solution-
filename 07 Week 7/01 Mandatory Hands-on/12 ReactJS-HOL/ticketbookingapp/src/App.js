import React from 'react';
import GuestPage from './GuestPage';
import UserPage from './UserPage';

class App extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      isLoggedIn: false
    };
  }

  handleLogin = () => {
    this.setState({ isLoggedIn: true });
  }

  handleLogout = () => {
    this.setState({ isLoggedIn: false });
  }

  render() {
    let content;
    if (this.state.isLoggedIn) {
      content = <UserPage />;
    } else {
      content = <GuestPage />;
    }

    return (
      <div className="App" style={{ textAlign: 'center', padding: '20px' }}>
        <h1>Flight Ticket Booking App</h1>
        {content}
        <br />
        {this.state.isLoggedIn ? (
          <button onClick={this.handleLogout}>Logout</button>
        ) : (
          <button onClick={this.handleLogin}>Login</button>
        )}
      </div>
    );
  }
}

export default App;
