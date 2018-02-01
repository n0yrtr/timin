import React, { Component } from 'react';
import logo from '../images/logo.svg';
import '../css/App.css';
import Category from './Category'

class App extends Component {
    constructor(props) {
        super(props);
    }
    render() {
        return (
          <div className="App">
            <header className="App-header">
              <img src={logo} className="App-logo" alt="logo" />
              <h1 className="App-title">Welcome to React</h1>
            </header>
              <div className="area_main">
                  <div>{this.props.data.id}</div>
                  <div className="area_current">
                  </div>
                  <div className="area_cards">
                      <Category />
                  </div>
              </div>

          </div>
        );
    }
}

export default App;
