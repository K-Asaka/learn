import tkinter as tk

root = tk.Tk()
root.title("grid: row, column")
root.geometry("300x100")
label1 = tk.Label(root, text="row=0, column=0", relief="groove")
label1.grid(row=0, column=0)
label2 = tk.Label(root, text="row=0, column=1", relief="groove")
label2.grid(row=0, column=1)
label3 = tk.Label(root, text="row=1, column=0", relief="groove")
label3.grid(row=1, column=0)
label4 = tk.Label(root, text="row=1, column=1", relief="groove")
label4.grid(row=1, column=1)
root.mainloop()
