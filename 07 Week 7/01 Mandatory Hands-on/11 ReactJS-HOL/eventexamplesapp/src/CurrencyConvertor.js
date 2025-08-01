import React from 'react';

class CurrencyConvertor extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      rupees: '',
      euro: ''
    };
  }

  handleChange = (e) => {
    this.setState({ rupees: e.target.value });
  }

  handleSubmit = (e) => {
    e.preventDefault();
    const conversionRate = 0.011; // Approx: 1 INR = 0.011 Euro
    const euro = this.state.rupees * conversionRate;
    this.setState({ euro: euro.toFixed(2) });
  }

  render() {
    return (
      <div style={{ marginTop: '40px' }}>
        <h2>Currency Convertor (INR to Euro)</h2>
        <form onSubmit={this.handleSubmit}>
          <input
            type="number"
            placeholder="Enter INR"
            value={this.state.rupees}
            onChange={this.handleChange}
          />{' '}
          <button type="submit">Convert</button>
        </form>
        {this.state.euro && (
          <p>Converted Amount: € {this.state.euro}</p>
        )}
      </div>
    );
  }
}

export default CurrencyConvertor;
