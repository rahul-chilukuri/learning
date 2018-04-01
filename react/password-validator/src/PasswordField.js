import React from 'react';
import {FormControl, FormGroup} from 'react-bootstrap';
import classNames from 'classnames';

class PasswordField extends React.Component {
  constructor(props) {
    super(props);
    this.handlePasswordChange = this.handlePasswordChange.bind(this);
  }
  handlePasswordChange(ev) {
    let { onPasswordChange } = this.props;
    onPasswordChange(ev.target.value);
  }

  satisfiedPercent() {
    let { principles, password } = this.props;
    let satisfiedCount = principles.map(p => p.predicate(password))
                                   .reduce((count, satisfied) => count + (satisfied ? 1 : 0) , 0);
    let principlesCount = principles.length;
    return (satisfiedCount / principlesCount) * 100.0;
  }

  inputColor() {
    let percentage = this.satisfiedPercent();
    return classNames({
      null: percentage = 0,
      error: (percentage > 0 && percentage < 25),
      warning: (percentage >= 50 && percentage < 100),
      success: (percentage = 100)
    });
  }

  render() {
    let { password } = this.props;
    return (
      <form>
        <FormGroup controlId="formBasicText" validationState={this.inputColor()}>
            <FormControl
                  type="password"
                  label='Password'
                  value={password}
                  onChange={this.handlePasswordChange}
            />
        </FormGroup>
      </form>
    );
  }
}

export default PasswordField;
