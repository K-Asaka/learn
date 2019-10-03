from scapy.all import IP, TCP, sniff

def pkt_callback(packet):
    if packet[TCP].payload:
        ml_payload = str(packet[TCP].payload)
        # POP
#        if "USER" in ml_payload or "PASS" in ml_payload:
        # IMAP
        if "login" in ml_payload:
            print(ml_payload)


print("sniff")
# POP
#sniff(filter="tcp port 110", prn=pkt_callback)
# IMAP
sniff(filter="tcp port 143", prn=pkt_callback)
