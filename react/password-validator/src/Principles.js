import React from 'react';
import classNames from 'classnames';

class Principles extends React.Component {
  principleSatisfied(principle) {
    let { password } = this.props;
    return principle.predicate(password);
  }
  principleClass(principle) {
    let satisfied = this.principleSatisfied(principle);
    return classNames({
      ["text-success"]: satisfied,
      ["text-danger"]: !satisfied
    });
  }
  render() {
    let { principles } = this.props;
    return ( <ul>
      {
        principles.map(principle =>
        <li className={this.principleClass(principle)}>
          <small>
            {principle.label}
          </small>
        </li>
      )}
    </ul> );
  }
}
export default Principles;
