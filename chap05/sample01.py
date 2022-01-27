import tkinter as tk

def press_f1(event):
    label["text"] = "pressed F1"

root = tk.Tk()
root.geometry("300x150")
root.title("function key")
label = tk.Label(root, text="function key(F1)", relief="groove")
# メインウィンドウを対象にキーのイベントを付ける
root.bind("<F1>", press_f1)
label.pack()
root.mainloop()
