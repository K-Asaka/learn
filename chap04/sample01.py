import tkinter as tk
import random

root = tk.Tk()
root.title("pack")
side_list = ["left", "right", "top", "bottom"]
label_list = []
for i in range(1, 31):
    side = side_list[random.randint(0, 3)]
    label_list.append(tk.Label(root, text="{0}:{1}".format("%02d"%i, side), relief="groove"))
    # ループにて"left"、"right"、"top"、"bottom"の順
    label_list[-1].pack(side=side)
root.mainloop()
