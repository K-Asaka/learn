# -*- coding: utf-8 -*-
import cv2
import numpy as np

try:
    # float32への変換と正規化
    img1 = cv2.imread('img/sample05.jpg', cv2.IMREAD_COLOR).astype(np.float32) / 255
    if img1 is None:
        raise FileNotFoundError('ファイルが見つかりません。')
    
    # float32への変換と正規化
    img2 = cv2.imread('img/gradient1.png', cv2.IMREAD_COLOR).astype(np.float32) / 255
    if img2 is None:
        raise FileNotFoundError('ファイルが見つかりません。')
    
    cv2.imshow('sample01', img1)
    cv2.imshow('sample02', img2)

    # 画像の乗算
    src1 = cv2.multiply(img1, img2)
    cv2.imshow('sample03', src1)

    cv2.waitKey(0)
    cv2.destroyAllWindows()

except FileNotFoundError as e:
    print(e)
