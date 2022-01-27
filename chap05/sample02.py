import tkinter as tk

def callback_func(event):
    # 識別子の取得
    label["text"] = event.keysym

    ks = event.keysym
    # 文字列比較による分岐
    if ks == "Control_L" or ks == "Control_R":
        label["text"] = "pressed control"

root = tk.Tk()
root.geometry("300x150")
root.title("keysym")
label = tk.Label(root, text="keysym", relief="groove")
# キーイベント
root.bind("<Key>", callback_func)
label.pack()
root.mainloop()
