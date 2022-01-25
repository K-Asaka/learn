import tkinter as tk
# rootの定義をしないと.StringVar()使用時にエラーになる
root = tk.Tk()
strvar = tk.StringVar()
print(strvar)
print(type(strvar))
