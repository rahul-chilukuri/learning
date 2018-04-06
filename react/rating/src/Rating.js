import React, { Component } from 'react';
//import ReactDOM from 'react-dom';
//import classNames from 'classnames';
import 'font-awesome/css/font-awesome.min.css';
import './Rating.css';

class Rating extends Component {
    constructor(props) {
        super(props);
        this.state = {
            size: props.size,
            selectedRating: props.selectedRating || 0,
            hoverValue: 0
        }

        this.handleRatingSelection = this.handleRatingSelection.bind(this);
        this.handleMouseOver = this.handleMouseOver.bind(this);
        this.handleMouseOut = this.handleMouseOut.bind(this);
    }

    handleRatingSelection(ev) {
        this.setState({ selectedRating: ev.target.parentElement.value });
    }

    handleMouseOver(ev) {
        this.setState({ hoverValue: ev.target.parentElement.value });
    }

    handleMouseOut(ev) {
        this.setState({ hoverValue: 0 });
    }

    render() {
      var listItems = [];
      for(var i=1; i<=this.state.size;i++) {
          var starClass = 'star';
          if(this.state.selectedRating && i <= this.state.selectedRating) {
              starClass+=' selected';
          }

          if(this.state.hoverValue && i <= this.state.hoverValue) {
              starClass+=' hover';
          }

          listItems.push(
              <li className={`${starClass}`}
                    key={i-1}
                    value={i}
                    onClick={this.handleRatingSelection}
                    onMouseOver={this.handleMouseOver}
                    onMouseOut={this.handleMouseOut}>
                    <i className='fa fa-star'/>
              </li>
          );
      }

        return (
            <div className='rating-stars'>
                <ul id='stars'>
                {listItems}
                </ul>
            </div>
        );
    }
}

export default Rating;
