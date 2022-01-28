import tkinter as tk

def update_state(event):
    # チェックボックス押下時にイベント発生なので、押下前のチェック状況が取得される
    button["state"] = tk.DISABLED if boolvar.get() else tk.NORMAL

root = tk.Tk()
boolvar = tk.BooleanVar()
root.geometry("280x120")
root.title("state")
checkbutton = tk.Checkbutton(text="はい、同意します", variable=boolvar)
button = tk.Button(text="次へ", state=tk.DISABLED)
checkbutton.pack(pady=5)
button.pack(pady=5)
checkbutton.bind("<Button-1>", func=update_state)
[widget.pack(pady=10) for widget in (checkbutton, button)]
root.mainloop()
