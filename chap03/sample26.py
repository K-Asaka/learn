import tkinter as tk

root = tk.Tk()
root.geometry("250x150")
root.title("listbox")
listbox = tk.Listbox(root, height=5)
for item in ["北海道", "東北", "関東", "中部", "近畿", "中国", "四国", "九州沖縄"]:
    listbox.insert(tk.END, item)
listbox.pack()
root.mainloop()
