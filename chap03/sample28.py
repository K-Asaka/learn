import tkinter as tk

root = tk.Tk()
root.geometry("280x250")
root.title("listbox scrollbar")
frame = tk.Frame(width=300, height=200)
frame.pack()
scrollbar = tk.Scrollbar(frame)
# side=tkinter.RIGHTは右位置、fill="y"は縦に一杯という意味
scrollbar.pack(side=tk.RIGHT, fill="y")
# マスターはウィンドウでなくフレーム
listbox = tk.Listbox(frame, height=10)
[listbox.insert(tk.END, "アイテム{0}".format(i)) for i in range(1, 21)]
listbox.pack()
# 部品の動きをスクロールバーに反映するようにする
listbox["yscrollcommand"] = scrollbar.set
# スクロールバーの動きを部品に反映するようにする
scrollbar["command"] = listbox.yview
# 指定のインデックスを選択し、さらに見える状態にする
default_index = 14
listbox.select_set(default_index)
listbox.see(default_index)
root.mainloop()
