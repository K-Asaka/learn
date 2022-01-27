import tkinter as tk
# tkinter.ttkのインポート
import tkinter.ttk as ttk

def upd_scale(event=None):
    message["text"] = "callback\n{0}\n\nIntVar.get()\n{1}\n\nscale.get()\n{2}\n\nscale[\"value\"]\n{3}".format(event, var_scale.get(), scale.get(), scale["value"])

root = tk.Tk()
root.geometry("280x250")
root.title("scale")
message = tk.Message(root, width=500, aspect=300, text="scale value")
# 浮動小数点数の場合
# var_scale = tk.DoubleVar()
var_scale = tk.IntVar()
# スケールの作成
scale = ttk.Scale(root, from_=-10, to=10, variable=var_scale, length=150, command=upd_scale)
[widget.pack() for widget in (message, scale)]
var_scale.set(0)
root.mainloop()
