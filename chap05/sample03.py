import tkinter as tk

def press_ctrlc(event):
    label["text"] = "ctrl c"
def press_ctrll_c(event):
    label["text"] = "ctrll after c"
def press_ctrlr_c(event):
    label["text"] = "ctrlr after c"

root = tk.Tk()
root.geometry("300x150")
root.title("shortcut key")
label = tk.Label(root, text="shortcut key test(ctrl c)", relief="groove")
# Ctrl+cのショートカット押し
root.bind("<Control-c>", press_ctrlc)
# これはエラーになります
# root.bind("<Control_L-c>", press_ctrl_c)
# 連続押しによる代用、ただしニュアンスが違ってくる
root.bind("<Control_L><c>", press_ctrll_c)
root.bind("<Control_R><c>", press_ctrlr_c)
label.pack()
root.mainloop()
