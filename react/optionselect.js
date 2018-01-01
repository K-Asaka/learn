var SingleSelection = React.createClass({
  getInitialState: function() {
    return { selection: this.props.selection };
  },
  handleChange: function(event) {
    console.log(event.target.value);
    this.setState({selection: event.target.value});
  },
  render: function() {
    return (<div>どれか1つを選んでください：
      <select
        onChange={this.handleChange}
        multiple={false}
        value={this.state.selection}>
        <option value="first">最初の選択肢</option>
        <option value="second">次の選択肢</option>
        <option value="third">最後の選択肢</option>
      </select>
    </div>);
  }
});

ReactDOM.render(
  <SingleSelection selection={'first'} />,
  document.getElementById('content')
);

