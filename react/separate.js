var SeparateJSX = React.createClass({
  render: function() {
    return (
      <h2>JSX on Separated File Speaking!</h2>
    );
  }
});

ReactDOM.render(
  <SeparateJSX />,
  document.getElementById('content')
);

