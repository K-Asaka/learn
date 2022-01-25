import tkinter as tk

def print_txtval():
    # 内容の取得
    val_en = en.get()
    print(val_en)

def en_del2():
    en.delete(2)

def en_del13():
    en.delete(1, 3)

def en_del0end():
    en.delete(0, tk.END)

def en_ins0():
    en.insert(0, "先頭に追加")

def en_ins3():
    en.insert(3, "3の位置に追加")

def en_insend():
    en.insert(tk.END, "最後に追加")

def en_upd():
    en.delete(0, tk.END)
    en.insert(0, "更新しました")

root = tk.Tk()
# テキストボックスの作成
en = tk.Entry()
bt = tk.Button(text="ボタン", command=print_txtval)
bt2 = tk.Button(text="delete(2)", command=en_del2)
bt3 = tk.Button(text="delete(1, 3)", command=en_del13)
bt4 = tk.Button(text="delete(0, tkinter.END)", command=en_del0end)
bt5 = tk.Button(text="insert(0,...)", command=en_ins0)
bt6 = tk.Button(text="insert(3,...)", command=en_ins3)
bt7 = tk.Button(text="insert(END,...)", command=en_insend)
bt8 = tk.Button(text="更新", command=en_upd)
[widget.pack() for widget in (en, bt, bt2, bt3, bt4, bt5, bt6, bt7, bt8)]
# フォーカスを当てる
en.focus_set()
root.mainloop()
