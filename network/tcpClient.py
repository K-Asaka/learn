# -*- coding: utf-8 -*-
import socket
import sys
import threading

destination = 'localhost'
if len(sys.argv) > 1:
    destination = sys.argv[1]

sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
sock.connect((destination, 50001))

def recvThread():
    while True:
        msg = sock.recv(1024)
        print(msg)

recvT = threading.Thread(target=recvThread)
recvT.start()

while True:
    try:
        kbIn = input("> ")
        if (kbIn == "q"):
            recvT._Thread__stop()
            exit()
        sock.send(kbIn)
    except:
        recvT._Thread__stop()
        exit()
