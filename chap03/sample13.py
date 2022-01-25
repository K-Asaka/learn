import tkinter as tk

def get_selpoint():
    # 選択された開始/終了位置
    sel_start = tx.index("sel.first")
    sel_end = tx.index("sel.last")
    lb["text"] = "sel_start:{0}, sel_end{1}".format(sel_start, sel_end)
    cursor_point = tx.index("insert")
    lb["text"] += "\ncursor_point:{0}".format(cursor_point)

root = tk.Tk()
lb = tk.Label()
tx = tk.Text(width=30, height=5)
bt = tk.Button(text="選択範囲", command=get_selpoint)
[widget.pack() for widget in (lb, tx, bt)]
root.mainloop()
