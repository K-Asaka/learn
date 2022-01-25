import tkinter as tk

def upd_ckval():
    # チェックの設定
    boolvar.set(not boolvar.get())

root = tk.Tk()
root.geometry("250x100")
boolvar = tk.BooleanVar()
# variableオプションにBooleanVarオブジェクトをセット
ck = tk.Checkbutton(text="チェックボックス", variable=boolvar)
bt = tk.Button(text="更新", command=upd_ckval)
[widget.pack() for widget in(ck, bt)]
root.mainloop()
