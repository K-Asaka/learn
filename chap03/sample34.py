import tkinter as tk
# tkinter内のfiledialogクラスをインポート
from tkinter import filedialog

def get_filepath():
    # .txt, .py, 全てのファイルの場合
    filetype_list = [("text file", "*.txt"), ("py file", "*.py"), ("all file", "*")]
    # ファイルパスの取得
    filepath = filedialog.askopenfilename(initialdir="", filetypes=filetype_list, title="select file")
    message["text"] = filepath

root = tk.Tk()
root.geometry("650x100")
root.title("filedialog")
message = tk.Message(root, text="file path", width=600)
button = tk.Button(text="get_filepath", command=get_filepath)
[widget.pack() for widget in (message, button)]
root.mainloop()
