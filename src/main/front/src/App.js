import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import Category from './Category'
import HTML5Backend from "react-dnd-html5-backend";
import { DragDropContextProvider } from 'react-dnd'

class App extends Component {
    constructor(props) {
        super(props);
    }
    render() {
        return (
            <DragDropContextProvider backend={HTML5Backend}>
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
                          <ul className="list_category">
                              <Category category />
                              <Category category />
                              <Category category />
                          </ul>
                      </div>
                  </div>

              </div>
            </DragDropContextProvider>
        );
    }
}

export default App;
