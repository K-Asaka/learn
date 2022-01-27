import tkinter


import tkinter as tk

root = tk.Tk()
root.geometry("400x300")
root.title("padx, pady, ipadx, ipady")

label = tk.Label(root, text="padx=50, pady=25, ipadx=75, ipady=150", background="cyan")
# 外側横余白=50、外側縦余白=25、内側横余白=75、内側縦余白=150
label.pack(padx=50, pady=25, ipadx=75, ipady=150)
root.mainloop()
