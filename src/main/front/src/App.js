import React, { Component } from 'react';
import logo from './test.png';
import './App.css';
import Category from './Category'
import Active from './Active'
import HTML5Backend from "react-dnd-html5-backend";
import { DragDropContextProvider } from 'react-dnd'

class App extends Component {
    constructor(props) {
        super(props);
        this.props = props;
    }
    componentWillMount() {
        this.setState({data: this.props.data, start: new Date()})
    }

    addCard(categoryId, title) {
        {
            var tmpState = this.state.data;
            for (var i in tmpState.categoryList) {
                if (tmpState.categoryList[i].id == categoryId) {
                    tmpState.categoryList[i].taskList.push({"id":Math.floor( Math.random() * (20000 + 1 - 10000) ) + 10000,"title":title,"workTime": 0});
                    this.setState({data: tmpState});
                }
            }
        }
    }

    handleDrop(category, card) {
        {
            console.log(category)
            var tmpState = this.state.data;
            for (var i in tmpState.categoryList) {
                if (tmpState.categoryList[i].id == category.id) {
                    for (var j in tmpState.categoryList) {
                        for (var k in tmpState.categoryList[j].taskList){
                            if (tmpState.categoryList[j].taskList[k].id == card.id) {
                                tmpState.categoryList[j].taskList.splice(k, 1);
                                tmpState.categoryList[i].taskList.push(card);
                                this.setState({data: tmpState});
                                return
                            }
                        }
                    }
                }
            }
        }
    }

    handleActiveDrop(card) {
        console.log(card);
        var tmpState = this.state.data;
        for (var i in tmpState.categoryList) {
            for (var j in tmpState.categoryList[i].taskList) {
                if (tmpState.categoryList[i].taskList[j].id == card.id) {
                    tmpState.active = card;

                    var timer = setInterval(this.tick(), 33)

                    this.setState({timer: timer, data: tmpState, start: Date.now() - tmpState.active.workTime});
                    return
                }
            }
        }
    }

    returnActive() {
        var tmpState = this.state.data;
        for (var i in tmpState.categoryList) {
            for (var j in tmpState.categoryList[i].taskList) {
                if (tmpState.categoryList[i].taskList[j].id == tmpState.active.id) {
                    tmpState.categoryList[i].taskList[j] = tmpState.active;
                    tmpState.active = null;
                    this.setState({data: tmpState});
                    return
                }
            }
        }
    }

    tick() {
        let t = this;
        return function() {
            if (t.state.data.active) {
                console.log("test:" + t.state.start);
                var elapsed = Date.now() - t.state.start;
                var tmpState = t.state.data;
                t.state.data.active.workTime = elapsed;
                t.setState({data: t.state.data})
            }
        }
    }




    render() {
        var list = [];
        var activeId = this.state.data.active != null ? this.state.data.active.id : null;
        for(var i in this.state.data.categoryList){
            list.push(<Category category={this.state.data.categoryList[i]}
                                activeId={activeId}
                                onDroped={(category, card) => this.handleDrop(category, card)}
                                onAddCardButtonClick={(categoryId, title) => this.addCard(categoryId, title)}
            />);
        }

        return (
            <DragDropContextProvider backend={HTML5Backend}>
              <div className="App">
                <header className="App-header">
                  <img src={logo} className="App-logo" alt="logo" />
                  <h1 className="App-title">Welcome to Timin</h1>
                </header>
                  <div className="area_main">
                      <Active task = {this.state.data.active} onReturnButtonClick={() => this.returnActive()} onDroped={card => this.handleActiveDrop(card)} />
                      <div className="area_cards">
                          <ul className="list_category">
                              {list}
                          </ul>
                          <button onClick={ () => this.addCard() } >追加</button>
                      </div>
                  </div>

              </div>
            </DragDropContextProvider>
        );
    }
}

export default App;
