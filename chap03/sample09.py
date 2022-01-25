import tkinter as tk

def print_txtval():
    # 内容の取得
    val_en = en.get()
    print(val_en)

root = tk.Tk()
# テキストボックスの作成
en = tk.Entry()
bt = tk.Button(text="ボタン", command=print_txtval)
[widget.pack() for widget in (en, bt)]
# フォーカスを当てる
en.focus_set()
root.mainloop()
