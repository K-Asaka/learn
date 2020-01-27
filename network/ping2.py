import subprocess

dest = input("Please Enter Destination: ")
p = subprocess.run(["ping", dest, "-n", "1"], stdout=subprocess.PIPE)
print(p.stdout.decode('cp932'))
print("リターンコード:", p.returncode)
