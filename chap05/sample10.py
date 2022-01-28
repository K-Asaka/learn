import tkinter as tk
import tkinter.ttk as ttk
# 1.pipなどで予めインストールが必要
import pyperclip

# スケール値を取得し、色彩値ラベル(10進数)の文字列を返す
def get_rgb_int_text(area):
    res = "("
    for rgb in rgbs:
        res = res + str(color_intvar[area][rgb].get()) + ", "
    res = res.rstrip(",")
    return res + ")"

# スケール値を取得し、色彩値ラベル(16進数)の文字列を返す
def get_rgb_hex_text(area):
    res = "#"
    for rgb in rgbs:
        # 16進数、左の"0x"削除、0文字埋めの2桁
        res = res + str(hex(color_intvar[area][rgb].get())).lstrip("0x").zfill(2)
    return res

# スケールが更新された
def update_scale(event=None):
    for area in areas:
        # 配色エリアの色の更新
        if area == area_text:
            message["foreground"] = get_rgb_hex_text(area)
        else:
            message["background"] = get_rgb_hex_text(area)
        # 色彩値ラベル(16進数)の更新
        label_hex[area]["text"] = get_rgb_hex_text(area)
        # 色彩値ラベル(10進数)の更新
        label_int[area]["text"] = get_rgb_int_text(area)

# ラベルがクリックされた
def click_label(event):
    # ラベルのテキストをコピー
    pyperclip.copy(event.widget["text"])

root = tk.Tk()
root.geometry("400x500")
root.title("color tool")
# 2.配色エリア
message = tk.Message(font=("ＭＳ ゴシック", 20, "bold"))
m_pady = m_ipady = 20
m_padx = m_ipadx = 40
message["text"] = "色彩値ラベルをクリックで\n色彩値をコピー出来ます"
# 配色エリアのを配置
message.pack(padx=m_padx, pady=m_pady, ipadx=m_ipadx, ipady=m_ipady)

# 3.対象エリアと色のキー、キー配列
area_text = 0
area_back = 1
r = 0
g = 1
b = 2
areas = [area_text, area_back]
rgbs = [r, g, b]
# 4.スケールのvariable
color_intvar = [[tk.IntVar(), tk.IntVar(), tk.IntVar()],    # text [r, g, b]
                [tk.IntVar(), tk.IntVar(), tk.IntVar()]]    # back [r, g, b]
# 5.色彩値ラベルのフレーム [text, back]
frame = [tk.Frame(root), tk.Frame(root)]
f_padx = f_pady = f_ipadx = f_ipady = 2
# 色彩値ラベル(10進数/16進数) [text, back]
label_int = []
label_hex = []
l_padx = 5
l_ipadx = 30
l_pady = 5
l_ipady = 5
# 6.RGB値スケールの配列。1次キーは対象エリア 2次キーはR値、G値、B値
scale = []
for area in areas:
    # 色彩値ラベルを作成
    label_int.append(tk.Label(frame[area], relief="groove"))
    label_hex.append(tk.Label(frame[area], relief="groove"))
    # 色彩値ラベルをフレームに配置
    label_hex[area].pack(side="left", padx=l_padx, pady=l_pady, ipadx=l_ipadx, ipady=l_ipady)
    label_int[area].pack(side="left", padx=l_padx, pady=l_pady, ipadx=l_ipadx, ipady=l_ipady)
    
    # 色彩値ラベルをクリックしたらclilck_label関数(ラベルのテキストをコピー)にコールバック
    label_hex[area].bind("<Button-1>", click_label)
    label_int[area].bind("<Button-1>", click_label)
    rgb_each = []
    for rgb in rgbs:
        color_intvar[area][rgb].set(255 - ((area + 1) * 80))
        rgb_each.append(ttk.Scale(root, from_=0, to=255, variable=color_intvar[area][rgb], length=255, command=update_scale))
    # area[r, g, b]
    scale.append(rgb_each)
    
for area in areas:
    # 色彩値ラベルのフレームを配置
    frame[area].pack(padx=f_padx, pady=f_pady, ipadx=f_ipadx, ipady=f_ipady)
    for rgb in rgbs:
        scale[area][rgb].pack()

# 7.予め配色エリアと色彩値ラベルを更新
update_scale()
root.mainloop()
