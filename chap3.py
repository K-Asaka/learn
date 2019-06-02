import tkinter

# ウィンドウ作成
root = tkinter.Tk()
root.title("リリーに質問")
root.minsize(640, 480)

# 画像表示
canvas = tkinter.Canvas(bg="black", width=640, height=480)
canvas.place(x=0, y=0)

# メインループ
root.mainloop()
