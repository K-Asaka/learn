import tkinter as tk
# 1.tkinter内のttkクラスをインポート
import tkinter.ttk as ttk

def press_button1():
    label1["text"] = "pressed button1"

def press_button2():
    label2["text"] = "pressed button2"

root = tk.Tk()
root.geometry("300x150")
root.title("Notebook")
# 2.Notebookオブジェクトを作成
notebook = ttk.Notebook(root)
# 3.タブとなるフレームを作成
tab1 = tk.Frame(notebook)
tab2 = tk.Frame(notebook)
# 4.Notebookにタブを追加
notebook.add(tab1, text="tab1")
notebook.add(tab2, text="tab2")
# ウィンドウサイズが変わったとき用にタブのレスポンシブを有効
notebook.pack(expand=True, fill="both")
# tab1をマスターとしたウィジェット
label1 = tk.Label(tab1, text="tab1 label1")
button1 = tk.Button(tab1, text="tab1 button1", command=press_button1)
# tab2をマスターとしたウィジェト
label2 = tk.Label(tab2, text="tab2 label2")
button2 = tk.Button(tab2, text="tab2 button2", command=press_button2)
[widget.pack(pady=10) for widget in (label1, button1, label2, button2)]
root.mainloop()
