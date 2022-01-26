import tkinter as tk
import tkinter.ttk as ttk

def get_comboitem(event):
    print(combobox.get())

root = tk.Tk()
root.geometry("280x150")
root.title("combobox event")
combobox = ttk.Combobox(root, value=("北海道", "東北", "関東", "中部", "近畿", "中国", "四国", "九州沖縄"))
# コンボボックス選択のイベントは"<<ComboboxSelected>>"を渡す
combobox.bind("<<ComboboxSelected>>", get_comboitem)
# 入力時のEnter用
combobox.bind("<Return>", get_comboitem)
combobox.pack()
root.mainloop()
