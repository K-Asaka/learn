var tableData = [
  {id: 1, name: '山田太郎', area: '東京都港区', number: '8513321'},
  {id: 2, name: '鈴木二郎', area: '神奈川県横浜市', number: '6912312'},
  {id: 3, name: '田中三郎', area: '千葉県銚子市', number: '7891254'}
];

var DispTable = React.createClass({
  render: function() {
    var tableBody = this.props.data.map(function(person) {
      return (<tr key={person.id}>
        <td>{person.name}</td>
        <td>{person.area}</td>
        <td>{person.number}</td>
      </tr>);
    });
    return (<table className="regularTable">
      <thead>
        <tr>
          <th>名前</th>
          <th>地域</th>
          <th>番号</th>
        </tr>
      </thead>
      <tbody>{tableBody}</tbody>
    </table>);
  }
});

ReactDOM.render(
  <DispTable data={tableData} />,
  document.getElementById('content')
);

