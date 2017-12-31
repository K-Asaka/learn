var TextInput = React.createClass({
  render: function() {
    return (<div>JSX Input: <input type='text' value='入力欄' /></div>);
  }
});

ReactDOM.render(
  <TextInput />,
  document.getElementById('content')
);

