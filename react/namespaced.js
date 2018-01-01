var tableColumns = ['名前', '地域', '番号'];

var tableData = [
  {id: 1, name: '山田太郎', area: '東京都港区', number: '8513321'},
  {id: 2, name: '鈴木二郎', area: '神奈川県横浜市', number: '6912312'},
  {id: 3, name: '田中三郎', area: '千葉県銚子市', number: '7891279'}
];

var ContactTable = React.createClass({
  render: function() {
    return (<table>
      {this.props.children}
    </table>);
  }
});

ContactTable.Header = React.createClass({
  render: function() {
    var tableTitles = this.props.title.map(function(cName, i) {
      return (<th key={i}>
        {cName}
      </th>);
    });
    return (<thead>
      <tr>
        {tableTitles}
      </tr>
    </thead>);
  }
});

ContactTable.Body = React.createClass({
  render: function() {
    var tableRows = this.props.data.map(function(person) {
      return (<tr key={person.id}>
        <td>{person.name}</td>
        <td>{person.area}</td>
        <td>{person.number}</td>
      </tr>);
    });
    return (<tbody>
      {tableRows}
    </tbody>);
  }
});

var DispTable = React.createClass({
  render: function() {
    return (<ContactTable className="regularTable">
      <ContactTable.Header title={this.props.title} />
      <ContactTable.Body data={this.props.data} />
    </ContactTable>);
  }
});

ReactDOM.render(
  <DispTable title={tableColumns} data={tableData} />,
  document.getElementById('content')
);

