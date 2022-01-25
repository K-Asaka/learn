import tkinter as tk

def print_selpoint():
    # 選択範囲の内容取得
    sel_start = tx.index("sel.first")
    sel_end = tx.index("sel.last")
    print(tx.get(sel_start, sel_end))

root = tk.Tk()
tx = tk.Text(width=30, height=5)
bt = tk.Button(text="選択範囲を出力", command=print_selpoint)
[widget.pack() for widget in (tx, bt)]
root.mainloop()
