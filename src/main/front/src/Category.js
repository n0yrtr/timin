import React, { Component } from 'react';
import './App.css';
import Card from './Card'
import { DropTarget } from "react-dnd";
import ItemTypes from './ItemTypes'
import PropTypes from 'prop-types'

const boxTarget = {
    drop() {
        return { name: 'Dustbin' }
    }
}

@DropTarget(ItemTypes.BOX, boxTarget, (connect, monitor) => ({
    connectDropTarget: connect.dropTarget(),
    isOver: monitor.isOver(),
    canDrop: monitor.canDrop(),
}))
class Category extends Component {
    static propTypes = {
        connectDropTarget: PropTypes.func.isRequired,
        isOver: PropTypes.bool.isRequired,
        canDrop: PropTypes.bool.isRequired,
    }
  render() {
    const isActive = this.props.canDrop && this.props.isOver;
    return this.props.connectDropTarget(
        <li>
            <ul className="list_card">
              {isActive ? 'Release to drop' : 'Drag a box here'}
              <Card/>
              <Card/>
              <Card/>
            </ul>
        </li>
    );
  }
}

export default Category;
