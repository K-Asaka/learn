# -*- coding: utf-8 -*-
import socket
import threading

sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
sock.bind((socket.gethostname(), 50001))
sock.listen(1)
conn, address = sock.accept()
print("Connected From " + str(address))
conn.send("Connected.")

def kbThread():
    while True:
        msg = input("> ")
        print("sent: " + msg)
        conn.send("I Enter: " + msg)

kbT = threading.Thread(target=kbThread)
kbT.start()

while True:
    try:
        msg = conn.recv(4096)
        if msg == "q":
            kbT._Thread__stop()
            conn.close()
            exit()
        print("rcv:" + msg)
        conn.send("Your Enter: " + msg)
    except:
        kbT._Thread__stop()
        exit()
