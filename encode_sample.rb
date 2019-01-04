# encoding: EUC-JP
euc_str = "日本語EUCの文字列"
p euc_str.encoding
utf8_str = euc_str.encode("utf-8")
p utf8_str.encoding

euc_str.encode!("utf-8")    # strはUTF-8になる
p euc_str.encoding
