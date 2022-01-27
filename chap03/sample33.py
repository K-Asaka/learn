import tkinter as tk

def file_new():
    label["text"] = "File new"

def file_open():
    label["text"] = "File open"

def file_save():
    label["text"] = "File save"

root = tk.Tk()
root.geometry("300x100")
root.title("menu cascade")
menubar = tk.Menu(root)
menu1 = tk.Menu(menubar, tearoff=False)
menubar.add_cascade(label="file", menu=menu1)
# メニューを作成(マスターは親メニュー)
menu11 = tk.Menu(menu1, tearoff=False)
# メニューにアイテムを追加
menu11.add_command(label="new", command=file_new)
menu11.add_command(label="open", command=file_open)
# 親メニューにメニューをカスケード
menu1.add_cascade(label="new/open", menu=menu11)
menu1.add_command(label="save", command=file_save)
root["menu"] = menubar
label = tk.Label(root)
label.pack()
root.mainloop()
