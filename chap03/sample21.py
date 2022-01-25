import tkinter as tk

root = tk.Tk()
root.title("Scrollbar Frame")
root.geometry("300x200")
# 1.フレームを作成する
fr = tk.Frame(width=300, height=200)
fr.pack()
# 2.スクロールバーを作成する
sc = tk.Scrollbar(fr)
# 3.スクロールバーを配置する時にsideやfillで位置などを指定する
sc.pack(side=tk.RIGHT, fill="y")
# 4.部品を作成する
tx = tk.Text(fr)
tx.pack()
# 5.部品の動きをスクロールバーに反映するようにする
tx["yscrollcommand"] = sc.set
# 6.スクロールバーの動きを部品に反映するようにする
sc["command"] = tx.yview
root.mainloop()
