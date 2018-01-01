var MultiSelection = React.createClass({
  getInitialState: function() {
    return {selection: this.props.selection};
  },
  handleChange: function(event) {
    var selection = this.state.selection
    var position = selection.indexOf(event.target.value);
    if (position === -1) {
      selection.push(event.target.value);
    } else {
      selection.splice(position, 1);
    }
    this.setState({selection: selection});
    console.log(this.state.selection);
  },
  render: function() {
    return (<div>いくつでも選んでください：
      <select onChange={this.handleChange} multiple={true}
        value={this.state.selection} size="3">
        <option value="first">最初の選択肢</option>
        <option value="second">次の選択肢</option>
        <option value="third">最後の選択肢</option>
      </select>
    </div>);
  }
});

ReactDOM.render(
  <MultiSelection selection={['first', 'third']}/>,
  document.getElementById('content')
);

