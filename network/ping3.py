import subprocess

def is_reached(dest):
    p = subprocess.run(["ping", dest, "-n", "1"], stdout=subprocess.PIPE)
    return p.returncode == 0

dest = input("Please Enter Destination: ")
print(is_reached(dest))
