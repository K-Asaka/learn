import tkinter as tk
# Comboboxはtkinter.ttkにある
import tkinter.ttk as ttk

def get_comboitem():
    # .get()で取得する
    print(combobox.get())

root = tk.Tk()
root.geometry("280x150")
root.title("combobox")
# itemはvaluesにタプルで渡します
combobox = ttk.Combobox(root, value=("北海道", "東北", "関東", "中部", "近畿", "中国", "四国", "九州沖縄"))
button = tk.Button(text="入力/選択値を出力", command=get_comboitem)
combobox.pack()
button.pack()
root.mainloop()
