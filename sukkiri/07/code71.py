# 1行日記を記録する
text = input('何を記録しますか？ >>')
file = open('diary.txt', 'a')
file.write(text + '\n')
file.close()
