import tkinter as tk

def set_evenitem():
    # .size()で要素数を取得しループ
    for i in range(1, listbox.size(), 2):
        listbox.select_set(i)

root = tk.Tk()
root.geometry("280x150")
root.title("listbox size")
strvar = tk.StringVar()
strvar.set(["北海道", "東北", "関東", "中部", "近畿", "中国", "四国", "九州沖縄"])
listbox = tk.Listbox(root, listvariable=strvar, selectmode="multiple", height=5)
button = tk.Button(text="偶数選択", command=set_evenitem)
[widget.pack() for widget in (listbox, button)]
root.mainloop()
