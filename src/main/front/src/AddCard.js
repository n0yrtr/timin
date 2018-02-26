import React, { Component } from 'react';
import './App.css';
import PropTypes from 'prop-types'

class AddCard extends Component {
    static propTypes = {
        isOver: PropTypes.bool.isRequired,
        canDrop: PropTypes.bool.isRequired,
        onAddButtonClick: PropTypes.bool.isRequired
    }
    render() {
    return (
        <li>
            <form>
                <textarea ref="title">default value</textarea>
            </form>
            <button className={'button'} onClick={ () => this.add() } >追加</button>
        </li>
    );
    }

    add() {
        {this.props.onAddButtonClick(this.refs.title.value)}
    }

}

export default AddCard;
