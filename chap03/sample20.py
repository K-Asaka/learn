import tkinter as tk

root = tk.Tk()
root.geometry("150x100")
root.title("Radiobutton")
intvar = tk.IntVar()
# 初期値をセット
intvar.set(1)
# ラジオボタンを作成
rd1 = tk.Radiobutton(text="ラジオ1", value=1, variable=intvar)
rd2 = tk.Radiobutton(text="ラジオ2", value=2, variable=intvar)
[widget.pack() for widget in (rd1, rd2)]
root.mainloop()
