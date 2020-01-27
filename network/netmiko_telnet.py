from netmiko import ConnectHandler

my_device = {
    "device_type": "cisco_ios_telnet",
    "host": "192.168.1.1",
    "password": "remote",
    "secret": "enable_password",
}

net_connect = ConnectHandler(**my_device)
net_connect.enable()

output = net_connect.send_command("sh ip int b")
print(output)

net_connect.disconnect()
