var CheckBox = React.createClass({
  getInitialState: function() {
    return { selection: this.props.selection};
  },
  handleChange: function(event) {
    var selection = this.state.selection
    var position = selection.indexOf(event.target.value);
    if (event.target.checked) {
      selection.push(event.target.value);
    } else {
      selection.splice(position, 1);
    }
    this.setState({ selection: selection });
    console.log(this.state.selection);
  },
  render: function() {
    return (<div>いくつでも選んでください：
      <div>
        <input
          type="checkbox"
          value="first"
          checked={this.state.selection.indexOf('first') !== -1}
          onChange={this.handleChange}
        />最初の選択肢
      </div>
      <div>
        <input
          type="checkbox"
          value="second"
          checked={this.state.selection.indexOf('second') !== -1}
          onChange={this.handleChange}
        />次の選択肢
      </div>
      <div>
        <input
          type="checkbox"
          value="third"
          checked={this.state.selection.indexOf('third') !== -1}
          onChange={this.handleChange}
        />最後の選択肢
      </div>
    </div>);
  }
});

ReactDOM.render(
  <CheckBox selection={['second', 'third']}/>,
  document.getElementById('content')
);

