# encoding: EUC-JP
euc_str = "日本語EUCの文字列"
p euc_str.encoding
utf8_str = euc_str.encode("utf-8")
p utf8_str.encoding

euc_str.encode!("utf-8")    # strはUTF-8になる
p euc_str.encoding

require "nkf"
utf8_str = NKF.nkf("-E -w -xm0", euc_str)
p utf8_str.encoding
# 入力時文字コードの指定を明示的に行わない場合
utf8_str = NKF.nkf("-w -xm0", euc_str)
p utf8_str.encoding
