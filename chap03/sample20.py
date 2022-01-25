import tkinter as tk

def get_rdval():
    # 選択値を取得する
    print(intvar.get())

root = tk.Tk()
root.geometry("150x100")
root.title("Radiobutton get")
intvar = tk.IntVar()
# 初期値をセット
intvar.set(0)
# ラジオボタンを作成
rd1 = tk.Radiobutton(text="ラジオ1", value=1, variable=intvar)
rd2 = tk.Radiobutton(text="ラジオ2", value=2, variable=intvar)
bt = tk.Button(text="選択値を出力", command=get_rdval)
[widget.pack() for widget in (rd1, rd2, bt)]
root.mainloop()
