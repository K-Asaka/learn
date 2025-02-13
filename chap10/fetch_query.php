<?php
// クエリ情報を取得
$name = htmlspecialchars($_GET['name'], ENT_QUOTES | ENT_HTML5, 'UTF-8');
// 入力に基づいて、挨拶メッセージを出力
if ($name !== '') {
    print('こんにちは、' . $name . 'さん！');
}
