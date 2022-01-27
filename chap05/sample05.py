import tkinter as tk

def callback_func(event):
    # 何ボタンかを取得
    button_num = event.num
    label["text"] = "button num:{0}".format(button_num)

root = tk.Tk()
root.geometry("250x180")
root.title("mouse x, y")
label = tk.Label(root, text="mouse", relief="groove")
# マウスボタンのイベント
root.bind("<Button>", callback_func)
label.pack()
root.mainloop()
