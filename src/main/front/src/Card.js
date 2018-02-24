import React, { Component } from 'react';
import './App.css';
import { DragSource } from "react-dnd"
import ItemTypes from './ItemTypes'
import PropTypes from 'prop-types'


const boxSource = {
    beginDrag(props) {
        return {
            name: props.name,
        }
    },

    endDrag(props, monitor) {
        const item = monitor.getItem()
        const dropResult = ""

        if (dropResult) {
            alert(`You dropped ${item.name} into ${dropResult.name}!`) // eslint-disable-line no-alert
        }
    },
}


@DragSource(ItemTypes.BOX, boxSource, (connect, monitor) => ({
    connectDragSource: connect.dragSource(),
    isDragging: monitor.isDragging(),
}))
class Card extends Component {
    static propTypes = {
        connectDragSource: PropTypes.func.isRequired,
        isDragging: PropTypes.bool.isRequired,
    }
  render() {
    const opacity = this.props.isDragging ? 'isDraggingNow' : ''
    return this.props.connectDragSource(
        <li>あああああああああああああああああああ{opacity}</li>
    );
  }
}

export default Card;
