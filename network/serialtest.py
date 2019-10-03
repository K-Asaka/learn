import serial
import sys
import threading

ser = serial.Serial('COM101', 9600)

def recvThread():
    while True:
        readdata = ser.read()
        sys.stdout.write(readdata)
    
recvT = threading.Thread(target=recvThread)
recvT.start()

while True:
    try:
        kbIn = input('> ')
        if (kbIn == ""):
            recvT._Thread__stop()
            exit()
        kbIn += "\r\n"
        ser.write(kbIn.encode())
    except:
        recvT._Thread__stop()
        exit()
