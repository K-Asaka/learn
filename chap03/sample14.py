import tkinter as tk

def get_text():
    # 内容の取得(1行6文字から3行4文字まで)
    print(tx.get("1.5", "3.4"))

root = tk.Tk()
tx = tk.Text(width=30, height=5)
bt = tk.Button(text="1行6文字から3行4文字まで取得", command=get_text)
[widget.pack() for widget in (tx, bt)]
root.mainloop()
