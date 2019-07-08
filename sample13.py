# -*- coding: utf-8 -*-
import cv2
import numpy as np

try:
    img = cv2.imread('img/sample04.jpg', cv2.IMREAD_COLOR)
    if img is None:
        raise FileNotFoundError('ファイルが見つかりません。')
    
    x = 150
    y = 0
    # 切り抜きたい画像のサイズ
    width = 180
    height = 150

    # Pythonのスライス機能で
    # 読み込んだndarrayから切り出す
    dst = img[y: (y + height), x: (x + width)]

    cv2.imshow('sample04', dst)
    cv2.waitKey(0)
    cv2.destroyAllWindows()

except FileNotFoundError as e:
    print(e)
