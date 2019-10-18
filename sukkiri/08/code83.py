# tkinterを使ってボタンのあるウィンドウを作成する
import tkinter as tk

root = tk.Tk()
root.geometry('240x240')
root.title('GUI Sample')
button = tk.Button(root, text='Hello, world')
button.pack()
root.mainloop()
