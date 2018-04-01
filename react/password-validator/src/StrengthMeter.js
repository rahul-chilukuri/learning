import React from 'react';
import {Panel,  ProgressBar} from 'react-bootstrap';
import Principles from './Principles';
import classNames from 'classnames';

class StrengthMeter extends React.Component {
  satisfiedPercent() {
    let { principles, password } = this.props;
    let satisfiedCount = principles.map(p => p.predicate(password))
                                   .reduce((count, satisfied) => count + (satisfied ? 1 : 0), 0);
    let principlesCount = principles.length;
    return (satisfiedCount / principlesCount) * 100.0;
  }

  inputColor() {
    let percentage = this.satisfiedPercent();
    return classNames({
      danger: (percentage < 25),
      warning: (percentage >= 50 && percentage < 100),
      success: (percentage = 100)
    });
  }

  render() {
    return (
      <Panel>
        <ProgressBar now={this.satisfiedPercent()} bsStyle={this.inputColor()} />
        <h5>A good password is:</h5>
        <Principles {...this.props} />
      </Panel>
    );
  }
}
export default StrengthMeter;
