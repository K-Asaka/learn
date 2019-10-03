from scapy.all import IP, TCP, send

send(IP(src="1.2.3.4",
        dst="192.168.11.12")/
    TCP(spot=51250,
        dport=80,
        flags="S"), count=5)
