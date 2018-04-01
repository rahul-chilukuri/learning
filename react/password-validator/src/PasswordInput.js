import React from 'react';
import { Grid, Row, Col } from 'react-bootstrap';

import PasswordField from './PasswordField';
import StrengthMeter from './StrengthMeter';

const LETTER_REGEX = /[A-Za-z]/;
const SPECIAL_CHARS_REGEX = /[^A-Za-z0-9]/;
const DIGIT_REGEX = /[0-9]/;

class PasswordInput extends React.Component {
  constructor(props) {
    super(props);
    this.state = { password: '' };
    this.changePassword = this.changePassword.bind(this);
  }
  changePassword(password) {
    this.setState({ password });
  }

  render() {
    let { goodPasswordPrinciples } = this.props;
    let { password } = this.state;
    return (
      <Grid>
        <br/>
        <Row>
          <Col md={6}>
            <PasswordField password={password}
            onPasswordChange={this.changePassword}
            principles={goodPasswordPrinciples} />
          </Col>
          <Col md={4}>
            <StrengthMeter password={password} principles={goodPasswordPrinciples} />
          </Col>
        </Row>
      </Grid>
    );
    }
}
PasswordInput.defaultProps = {
  goodPasswordPrinciples: [
    {
      label: "6+ characters",
      predicate: password => password.length >= 6
    },
    {
      label: "with at least one digit",
      predicate: password => password.match(DIGIT_REGEX) !== null
    },
    {
      label: "with at least one special character",
      predicate: password => password.match(SPECIAL_CHARS_REGEX) !== null
    },
    {
      label: "with at least one letter",
      predicate: password => password.match(LETTER_REGEX) !== null
    }
]};
export default PasswordInput;
