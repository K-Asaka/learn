import tkinter as tk

def file_open():
    label["text"] = "File open"

def file_save():
    label["text"] = "File save"

def edit_copy():
    label["text"] = "Edit copy"

def edit_paste():
    label["text"] = "Edit paste"

root = tk.Tk()
root.geometry("200x100")
root.title("menu")
# 1.メニューバーを作成(マスターはウィンドウ)
menubar = tk.Menu(root)
# 2.メニューを作成(マスターはメニューバー)、tearoff=Falseにして切り取らせないようにする
menu1 = tk.Menu(menubar, tearoff=False)
# 3.メニューにアイテムを追加
menu1.add_command(label="open", command=file_open)
# セパレーター
menu1.add_separator()
menu1.add_command(label="save", command=file_save)
# 4.メニューバーにメニューをカスケード
menubar.add_cascade(label="file", menu=menu1)
menu2 = tk.Menu(menubar, tearoff=False)
menu2.add_command(label="copy", command=edit_copy)
menu2.add_command(label="paste", command=edit_paste)
menubar.add_cascade(label="edit", menu=menu2)
# 5.ウィンドウにメニューバーを追加
root["menu"] = menubar
label = tk.Label(root)
label.pack()
root.mainloop()
