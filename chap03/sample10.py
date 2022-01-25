import tkinter as tk
# rootの定義をしないと.StringVar()使用時にエラーになる
root = tk.Tk()
strvar = tk.StringVar()
en = tk.Entry(textvariable=strvar)
strvar.set("あいうえお")
en.pack()
root.mainloop()
