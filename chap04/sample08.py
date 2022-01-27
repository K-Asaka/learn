import tkinter as tk

root = tk.Tk()
root.title("grid: sticky")
root.geometry("340x140")
frame1 = tk.Frame(root, background="#eee")
frame2 = tk.Frame(root, background="#eee")
# rowspan=2
label1 = tk.Label(frame1, text="r0,c0,rs2", relief="groove")
# sticky=tk.N+tk.Sのようにも書ける。上から下
label1.grid(row=0, column=0, rowspan=2, sticky="ns")
label2 = tk.Label(frame1, text="row0,col1", relief="groove")
label2.grid(row=0, column=1)
label3 = tk.Label(frame1, text="row1,col1", relief="groove")
label3.grid(row=1, column=1)
label4 = tk.Label(frame1, text="row2,col1", relief="groove")
label4.grid(row=2, column=1)

# columnspan=3
label21 = tk.Label(frame2, text="+++ r0,c0,cs3 +++", relief="groove")
# sticky=tk.W+tk.Eのようにも書ける。左から右
label21.grid(row=0, column=0, columnspan=3, sticky="we")
label22 = tk.Label(frame2, text="row1,col0", relief="groove")
label22.grid(row=1, column=0)
label23 = tk.Label(frame2, text="row1,col1", relief="groove")
label23.grid(row=1, column=1)
label24 = tk.Label(frame2, text="row1,col2", relief="groove")
label24.grid(row=1, column=2)
frame1.pack(padx=5, pady=5)
frame2.pack(padx=5, pady=5)
root.mainloop()
