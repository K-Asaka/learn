import tkinter as tk

def ins_cursor_point():
    # テキストの追加
    tx.insert(tx.index("insert"), "+++++")

root = tk.Tk()
tx = tk.Text(width=30, height=5)
bt = tk.Button(text="カーソル位置に+++++を追加", command=ins_cursor_point)
[widget.pack() for widget in (tx, bt)]
root.mainloop()
