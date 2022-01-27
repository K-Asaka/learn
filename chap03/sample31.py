import tkinter as tk

def upd_spinbox(event=None):
    label["text"] = var_spinbox.get()

root = tk.Tk()
root.geometry("280x150")
root.title("spinbox")
var_spinbox = tk.StringVar()
label = tk.Label(root, text="スピンボックスの値")
# スピンボックス:-10から10まで0.5づつ
spinbox = tk.Spinbox(root, value=tuple("item_{0}".format(i) for i in range(1, 11)), textvariable=var_spinbox, command=upd_spinbox)
spinbox.bind("<Return>", upd_spinbox)
[widget.pack() for widget in (label, spinbox)]
root.mainloop()
