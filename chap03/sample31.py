import tkinter as tk

def upd_spinbox(event=None):
    label["text"] = var_spinbox.get()

root = tk.Tk()
root.geometry("280x150")
root.title("spinbox")
var_spinbox = tk.StringVar()
label = tk.Label(root, text="スピンボックスの値")
# スピンボックス:-10から10まで0.5づつ
spinbox = tk.Spinbox(root, from_=-10, to=10, increment=0.5, state="readonly", textvariable=var_spinbox, command=upd_spinbox)
var_spinbox.set(0.0)
spinbox.bind("<Return>", upd_spinbox)
[widget.pack() for widget in (label, spinbox)]
root.mainloop()
