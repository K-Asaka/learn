import socket

for port in range(75, 85):
    with socket.socket() as s:
        ret_code = s.connect_ex(("localhost", port))

    if ret_code == 0:
        print("port %d is open" % (port))
print("scanning complete")
