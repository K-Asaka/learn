strings = ["あいうえお", 'xxxyyy', "αxxβyyγ"]
print(strings)
index = 0
for string in strings:
    if 'xxx' in string:
        strings[index] = '＜検閲削除＞'
    index += 1
print(strings)
