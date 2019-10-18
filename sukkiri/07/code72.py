# 用が済んだらすぐに閉じる
text = input('今日は何をした？ >>')
with open('diary.txt', 'a') as file:
    file.write(text + '\n')
