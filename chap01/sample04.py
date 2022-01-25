import tkinter as tk

# ボタンが押された時に呼び出される
def action_btn_press():
    print("ボタンが押されました")

root = tk.Tk()
root.title("アクションの組み込み")
root.geometry("350x150")
# 部品(widget)の作成
lb = tk.Label(text="ラベル")
# commandオプションに関数名を指定
bt = tk.Button(text="ボタン", command=action_btn_press)
# 配置
lb.pack()
bt.pack()
root.mainloop()
