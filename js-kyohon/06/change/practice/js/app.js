var practice = document.getElementById('practice');
practice.innerHTML = '<h1>れんしゅう</h1>';
practice.style.backgroundColor = '#999999';
practice.style.fontSize = '30px';
practice.style.color = '#FFFFFF';

// 要素を追加する
var first = document.createElement('div');
first.setAttribute('id', 'first');
first.innerHTML = '<p>要素を追加</p>';
practice.insertBefore(first, null);
