var SimpleTable = React.createClass({
  render: function() {
    return (<table className="regularTable">
      <tr>
        <th>名前</th>
        <th>地域</th>
        <th>番号</th>
      </tr>
      <tr>
        <td>山田太郎</td>
        <td>東京都港区</td>
        <td>8513321</td>
      </tr>
      <tr>
        <td>鈴木二郎</td>
        <td>神奈川県横浜市</td>
        <td>6912312</td>
      </tr>
    </table>);
  }
});

ReactDOM.render(
  <SimpleTable />,
  document.getElementById('content')
);

