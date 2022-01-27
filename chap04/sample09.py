import tkinter as tk

root = tk.Tk()
root.geometry("600x600")
root.title(".place()")
# frame1
frame1 = tk.Frame(root, width=600, height=300, background="#fef")
label11 = tk.Label(frame1, text="[frame1 600x300]\nrelx=0.25,rely=0.25\nrelwidth=0.5,relheight=0.5", background="#fdf")
# .place()で配置、マスターに対して座標やサイズを設定
label11.place(relx=0.25, rely=0.25, relwidth=0.5, relheight=0.5)
frame1.pack()
# frame2
frame2 = tk.Frame(root, width=600, height=300, background="#eef")
label21 = tk.Label(frame2, text="[frame2 600x300]\nx=50,y=50\nwidth=150,height=150", background="#ddf")
# .place()で配置、絶対的な座標やサイズを設定
label21.place(x=50, y=50, width=150, height=150)
label22 = tk.Label(frame2, text="[frame2 600x300]\nrelx=0.5,rely=0.5\nrelwidth=0.25\nrelheight=0.25", background="#ddf")
# .place()で配置、マスターに対して座標やサイズを設定
label22.place(relx=0.5, rely=0.5, relwidth=0.25, relheight=0.25)
frame2.pack()
#root
label01 = tk.Label(root, text="[root 600x600]\nx=100,y=100\nwidth=150,height=150", background="#efe")
# .place()で配置、絶対的な座標やサイズを設定
label01.place(x=100, y=100, width=150, height=150)
label02 = tk.Label(root, text="[root 600x600]\nrelx=0.25,rely=0.25\nrelwidth=0.25,relheight=0.25", background="#efe")
# .place()で配置、マスターに対して座標やサイズを設定
label02.place(relx=0.5, rely=0.5, relwidth=0.25, relheight=0.25)
root.mainloop()
