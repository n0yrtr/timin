import React, { Component } from 'react';
import '../css/App.css';
import Card from './Card'

class Category extends Component {
  render() {
    return (
          <ul className="list_category">
              <Card/>
              <Card/>
              <Card/>
          </ul>
    );
  }
}

export default Category;
