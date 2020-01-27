import subprocess

def is_reached(dest):
    p = subprocess.run(["ping", dest, "-n", "1"], stdout=subprocess.PIPE)
    return p.returncode == 0

with open('network/destinations.txt', 'r') as f:
    for line in f:
        dest = line.strip()
        print(dest)
        print("OK" if is_reached(dest) else "NG")
