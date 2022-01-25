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

root = tk.Tk()
# テキストボックスの作成
en = tk.Entry()
bt = tk.Button(text="ボタン", command=print_txtval)
bt2 = tk.Button(text="delete(2)", command=en_del2)
bt3 = tk.Button(text="delete(1, 3)", command=en_del13)
bt4 = tk.Button(text="delete(0, tkinter.END)", command=en_del0end)
[widget.pack() for widget in (en, bt, bt2, bt3, bt4)]
# フォーカスを当てる
en.focus_set()
root.mainloop()
