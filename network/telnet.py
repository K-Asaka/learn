from telnetlib import Telnet

with Telnet("192.168.1.1", 23) as tn:
    tn.read_until(b"password:")
    tn.write(b"remote\n")

    tn.read_until(b">")
    tn.write(b"enable\n")

    tn.read_until(b"password:")
    tn.write(b"enable_password\n")

    tn.read_until(b"#")
    tn.write(b"show ip interface brief\n")

    output = tn.read_until(b"#")
    print(output.decode('utf-8'))

    tn.write(b"exit\n")
