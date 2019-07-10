# -*- coding: utf-8 -*-
import cv2
import numpy as np

try:
    img = cv2.imread('img/sample04.jpg', cv2.IMREAD_COLOR)
    if img is None:
        raise FileNotFoundError('ファイルが見つかりません。')
    
    # 横方向のエッジ検出
    sob1 = cv2.Sobel(img, ddepth=-1, dx=0, dy=1)
    cv2.imshow('sample01', sob1)

    # 縦方向のエッジ検出
    sob2 = cv2.Sobel(img, ddepth=-1, dx=1, dy=0)
    cv2.imshow('sample02', sob2)

    cv2.waitKey(0)
    cv2.destroyAllWindows()

except FileNotFoundError as e:
    print(e)
