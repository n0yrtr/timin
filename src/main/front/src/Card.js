import React, { Component } from 'react';
import './App.css';
import { DragSource } from "react-dnd"
import ItemTypes from './ItemTypes'
import PropTypes from 'prop-types'


const boxSource = {
    beginDrag(props) {
        return {
            task: props.task,
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

    getTimeSpan(elapsed) { // 754567(ms) -> "12:34.567"
        console.log("elapsed:" + elapsed);
        var m = String(Math.floor(elapsed/1000/60)+100).substring(1);
        var s = String(Math.floor((elapsed%(1000*60))/1000)+100).substring(1);
        var ms = String(elapsed % 1000 + 1000).substring(1);
        return m+":"+s+"."+ms;
    }

    static propTypes = {
        connectDragSource: PropTypes.func.isRequired,
        isDragging: PropTypes.bool.isRequired,
    }
  render() {
    const opacity = this.props.isDragging ? 'isDraggingNow' : ''
    return this.props.connectDragSource(
        <li>
            {this.props.task.title}{opacity}
            <div>{this.getTimeSpan(this.props.task.workTime)}</div>
        </li>
    );
  }
}

export default Card;
