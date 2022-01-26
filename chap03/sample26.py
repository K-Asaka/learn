import tkinter as tk

def get_listitem():
    # 選択中アイテムのインデックス
    print(listbox.curselection())

root = tk.Tk()
root.geometry("280x150")
root.title("get listitem")
strvar = tk.StringVar()
strvar.set(["北海道", "東北", "関東", "中部", "近畿", "中国", "四国", "九州沖縄"])
# 1行で書くことも出来る strvar = tk.StringVar(value=["北海道", "東北", "関東", "中部", "近畿", "中国", "四国", "九州沖縄"])
# アイテムの定義にStringVarを使用、また複数行選択可にする
listbox = tk.Listbox(root, listvariable=strvar, selectmode="multiple", height=5)
button = tk.Button(text="選択値を出力", command=get_listitem)
[widget.pack() for widget in (listbox, button)]
root.mainloop()
