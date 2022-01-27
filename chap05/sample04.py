import tkinter as tk

def callback_func(event):
    # カーソル位置の取得
    label["text"] = "x:{0},y:{1}".format(event.x, event.y)

root = tk.Tk()
root.geometry("250x180")
root.title("mouse x, y")
label = tk.Label(root, text="mouse", relief="groove")
# マウスボタンのイベント
root.bind("<Button>", callback_func)
label.pack()
root.mainloop()
