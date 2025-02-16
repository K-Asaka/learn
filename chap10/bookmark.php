<?php
header('Content-Type: application/json;;charset=UTF-8');
// はてブAPIへの問い合わせURLを組み立て
$url = 'https://b.hatena.ne.jp/entry/jsonlite/?url=' . $_GET['url'];
// 問い合わせ結果をそのまま出力
print(file_get_contents($url, false, stream_context_create(['http' => ['header' => 'User-Agent: MySample']])));
