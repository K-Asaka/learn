# encoding: EUC-JP
euc_str = "���ܸ�EUC��ʸ����"
p euc_str.encoding
utf8_str = euc_str.encode("utf-8")
p utf8_str.encoding

euc_str.encode!("utf-8")    # str��UTF-8�ˤʤ�
p euc_str.encoding
