import tkinter as tk

def btn_press():
    print("ボタンが押されました")

root = tk.Tk()
root.geometry("150x80")
# ボタンの作成、commandオプションで押下時に呼び出す関数を指定できる
bt = tk.Button(text="ボタン", command=btn_press)
bt.pack()
root.mainloop()
