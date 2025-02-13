<?php
// ポストデータを取得
$name = htmlspecialchars($_POST['name'], ENT_QUOTES | ENT_HTML5, 'UTF-8');
// 入力に基づいて、挨拶メッセージを出力
if ($name !== '') {
    print('こんにちは、' . $name . 'さん！');
}
