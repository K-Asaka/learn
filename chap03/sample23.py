import tkinter as tk

root = tk.Tk()
root.geometry("250x130")
root.title("LabelFrame")
# ラベルフレームを作成
frame = tk.LabelFrame(root, text="ラベルフレーム", foreground="#008800")
intvar = tk.IntVar()
intvar.set(0)
radio1 = tk.Radiobutton(frame, text="ラジオ1", value=1, variable=intvar)
radio2 = tk.Radiobutton(frame, text="ラジオ2", value=2, variable=intvar)
radio3 = tk.Radiobutton(frame, text="ラジオ3", value=3, variable=intvar)
[widget.pack() for widget in (frame, radio1, radio2, radio3)]
root.mainloop()
