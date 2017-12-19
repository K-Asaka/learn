$(function() {
  $('#btn').on('click', function() {
    $.ajax({
      url: "http://zipcloud.ibsnet.co.jp/api/search?zipcode=" + $('#zipcode').val(),
      dataType: 'jsonp',
    }).done(function(data) {
      if (data.results) {
        // データが取得できた時の処理を書く
      } else {
        alert('該当するデータが見つかりませんでした');
      }
    }).fail(function(data) {
      alert('通信に失敗しました');
    });
  });
});
