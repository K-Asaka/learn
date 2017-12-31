var RadioButton = React.createClass({
  render: function() {
    return (<div>どれか1つを選んでください：
      <div>
        <input
          type="radio"
          name="三択"
          value="first"
          defaultChecked
        />最初の選択肢
      </div>
      <div>
        <input
          type="radio"
          name="三択"
          value="second"
        />次の選択肢
      </div>
      <div>
        <input
          type="radio"
          name="三択"
          value="third"
        />最後の選択肢
      </div>
    </div>);
  }
});

ReactDOM.render(
  <RadioButton />,
  document.getElementById('content')
);

