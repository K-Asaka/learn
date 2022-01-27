import tkinter as tk
import tkinter.scrolledtext as tksc
# tkinter内のfiledialogクラスをインポート
from tkinter import filedialog

def get_filepath():
    # .txt, .py, 全てのファイルの場合
    filetype_list = [("text file", "*.txt"), ("py file", "*.py"), ("all file", "*")]
    # ファイルオブジェクト(読み込みモード)
    # ファイルの選択が出来ない場合はファイル権限を替えてみましょう
    fileobj = filedialog.askopenfile(initialdir="", filetypes=filetype_list, title="select file")
    if fileobj is not None:
        message["text"] = str(fileobj)
        content = fileobj.read()
        scrolledtext.insert(tk.END, content)
        fileobj.close()

root = tk.Tk()
root.geometry("550x250")
root.title("filedialog_read")
message = tk.Message(root, text="file path", width=550)
button = tk.Button(text="get_filepath", command=get_filepath)
scrolledtext = tksc.ScrolledText(root, height=10, width=70)
[widget.pack() for widget in (message, button, scrolledtext)]
root.mainloop()
