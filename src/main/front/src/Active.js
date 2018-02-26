import React, { Component } from 'react';
import './App.css';
import Card from './Card'
import { DropTarget } from "react-dnd";
import ItemTypes from './ItemTypes'
import AddCard from './AddCard'
import PropTypes from 'prop-types'


const activeTarget = {
    drop(props, monitor) {
        console.log(props);
        console.log(monitor.getItem())
        props.onDroped(monitor.getItem().task)
    }
}

@DropTarget(ItemTypes.BOX, activeTarget, (connect, monitor) => ({
    connectDropTarget: connect.dropTarget(),
    isOver: monitor.isOver(),
    canDrop: monitor.canDrop(),
}))
class Active extends Component {
    static propTypes = {
        connectDropTarget: PropTypes.func.isRequired,
        isOver: PropTypes.bool.isRequired,
        canDrop: PropTypes.bool.isRequired,
        onReturnButtonClick: PropTypes.bool.isRequired,
    }
  render() {

    const isActive = this.props.canDrop && this.props.isOver;
    return this.props.connectDropTarget(
        <div className="area_current">
            {isActive ? 'Release to drop' : 'Drag a box here'}
            {this.props.task &&  <div>
                <Card task={this.props.task} />
                <button className={'button'} onClick={ () => this.props.onReturnButtonClick() }>↩</button>
            </div>}
            {!this.props.task && 'nothing' }




        </div>
    );
  }



}

export default Active;
