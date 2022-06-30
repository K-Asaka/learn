# python3 listing11-14.py < somefile.txt
import sys

def process(string):
    print('処理中:', string)

for line in sys.stdin:
    process(line)
