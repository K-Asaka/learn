import tkinter as tk

def set_allitem():
    # 0, tkinter.ENDで全てのアイテムが選択される
    listbox.select_set(0, tk.END)
def clear_item():
    # 引数の渡し方は.select_set()と同じ
    listbox.select_clear(0, tk.END)

root = tk.Tk()
root.geometry("280x150")
root.title("listbox set clear")
strvar = tk.StringVar()
strvar.set(["北海道", "東北", "関東", "中部", "近畿", "中国", "四国", "九州沖縄"])
listbox = tk.Listbox(root, listvariable=strvar, selectmode="multiple", height=5)
button1 = tk.Button(text="全選択", command=set_allitem)
button2 = tk.Button(text="全解除", command=clear_item)
[widget.pack() for widget in (listbox, button1, button2)]
root.mainloop()
