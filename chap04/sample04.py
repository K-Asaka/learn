import tkinter as tk

root = tk.Tk()
root.geometry("300x250")
root.title("expand")
label = tk.Label(root, text='fill="y", expand=True, pady=10', relief="groove")
# レスポンシブ有り
label.pack(fill="y", expand=True, pady=10)
root.mainloop()
