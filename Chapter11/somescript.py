import sys
text = sys.stdin.read()
words = text.split()
wordcount = len(words)
print('単語数:', wordcount)

# cat somefile.txt | python3 somescript.py