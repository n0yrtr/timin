import React, { Component } from 'react';
import './App.css';
import Card from './Card'
import { DropTarget } from "react-dnd";
import ItemTypes from './ItemTypes'
import AddCard from './AddCard'
import PropTypes from 'prop-types'


const categoryTarget = {
    drop(props, monitor) {
        console.log(props);
        console.log(monitor.getItem())
        props.onDroped(props.category, monitor.getItem().task)
    }
}

@DropTarget(ItemTypes.BOX, categoryTarget, (connect, monitor) => ({
    connectDropTarget: connect.dropTarget(),
    isOver: monitor.isOver(),
    canDrop: monitor.canDrop(),
}))
class Category extends Component {
    static propTypes = {
        connectDropTarget: PropTypes.func.isRequired,
        isOver: PropTypes.bool.isRequired,
        canDrop: PropTypes.bool.isRequired,
        onAddCardButtonClick: PropTypes.bool.isRequired
    }
  render() {
     var list = [];
     for(var i in this.props.category.taskList){
         if (this.props.category.taskList[i].id != this.props.activeId) {
             list.push(<Card task={this.props.category.taskList[i]} />);
         }
     }
    const isActive = this.props.canDrop && this.props.isOver;
    return this.props.connectDropTarget(
        <li>
            <ul className="list_card">
                <AddCard onAddButtonClick= { title => this.props.onAddCardButtonClick(this.props.category.id, title)}/>
                {isActive ? 'Release to drop' : 'Drag a box here'}
                {this.props.category.title}
                {list}
            </ul>
        </li>
    );
  }



}

export default Category;
