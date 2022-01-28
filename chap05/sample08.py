import tkinter as tk

def enter_label(event):
    # .widgetでイベント対象ウィジェットのオブジェクトを取得できる
    event.widget["background"] = "#bfb"
def leave_label(event):
    event.widget["background"] = "#bbf"
    
root = tk.Tk()
root.geometry("300x120")
root.title("Enter/Leave")
label = tk.Label(root, text="mouse here", background="#bbf")
label.pack(ipadx=70, pady=35)
# <Enter>:マウスカーソルがウィジェットの中
label.bind("<Enter>", enter_label)
# <Leave>:マウスカーソルがウィジェットの外
label.bind("<Leave>", leave_label)
label.pack()
root.mainloop()
