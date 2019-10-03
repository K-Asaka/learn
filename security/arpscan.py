from scapy.all import Ether, ARP, srp

nw = "192.168.0.0/24"
pkt = Ether(dst="FF:FF:FF:FF:FF:FF")/ARP(op=1, pdst=nw)
ans, uans = srp(pkt, timeout=5)
for send, recv in ans:
    print(recv.sprintf("MAC:%Ether.src% IP:%ARP.psrc%"))

