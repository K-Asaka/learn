import tkinter as tk

root = tk.Tk()
root.title("部品(widget)の作成")
root.geometry("350x150")
# 部品(widget)の作成
lb = tk.Label(text="ラベル")
bt = tk.Button(text="ボタン")
# 配置
lb.pack()
bt.pack()
root.mainloop()
