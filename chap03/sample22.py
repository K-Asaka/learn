import tkinter as tk

root = tk.Tk()
root.title("Scrollbar Frame horizontal")
root.geometry("350x200")
fr = tk.Frame(width=300, height=200)
fr.pack()
sc = tk.Scrollbar(fr)
# x方向(横方向)スクロールバー作成
scx = tk.Scrollbar(fr, orient="horizontal")
sc.pack(side=tk.RIGHT, fill="y")
# 下位置、横に一杯
scx.pack(side=tk.BOTTOM, fill="x")
tx = tk.Text(fr)
# 折り返しをしない
tx["wrap"] = tk.NONE
tx.pack()
tx["yscrollcommand"] = sc.set
# 部品の動きをx方向(横方向)スクロールバーに反映
tx["xscrollcommand"] = scx.set
sc["command"] = tx.yview
# x方向(横方向)スクロールバーの動きを部品に反映
scx["command"] = tx.xview
root.mainloop()
