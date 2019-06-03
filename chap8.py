import tkinter

# 解読関数
def decode_line(event):
    global current_line, bgimg
    if current_line >= len(scenario):
        return
    # 1行読み込み
    line = scenario[current_line]
    current_line = current_line + 1
    line = line.replace("\\n", "\n").strip()
    params = line.split(" ")
    # 分岐
    if line[0] != "#":
        message["text"] = line
    elif params[0] == "#back":
        canvas.delete("all")
        bgimg = tkinter.PhotoImage(file=params[1])
        canvas.create_image(450, 230, image=bgimg)

# ウィンドウ作成
root = tkinter.Tk()
root.title("よろしくアドベンチャー")
root.minsize(900, 460)
root.option_add("*font", ["メイリオ", 14])
# キャンバス作成
canvas = tkinter.Canvas(width=900, height=460)
canvas.place(x=0, y=0)
# メッセージエリア
message = tkinter.Label(width=70, height=5, wraplength=840, bg="white", justify="left", anchor="nw")
message.place(x=28, y=284)
message["text"] = "クリックしてスタート"

# ファイル読み込み
scenario = []
file = open("img8/scenario.txt", "r", encoding="utf-8")
while True:
    line = file.readline()
    scenario.append(line)
    print(line)
    if not line:
        file.close()
        break

# 現在の行数
current_line = 0
# イベント設定
message.bind("<Button-1>", decode_line)
# 画像
bgimg = None
lcharimg = None
ccharimg = None
rcharimg = None

root.mainloop()
