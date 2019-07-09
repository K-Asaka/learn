# -*- coding: utf-8 -*-
import cv2
import numpy as np

try:
    img1 = cv2.imread('img/sample05.jpg', cv2.IMREAD_COLOR)
    if img1 is None:
        raise FileNotFoundError('ファイルが見つかりません');
    # グラデーション画像
    img2 = cv2.imread('img/gradient1.png', cv2.IMREAD_COLOR)
    if img2 is None:
        raise FileNotFoundError('ファイルがみつかりません。')
    
    cv2.imshow('sample01', img1)
    cv2.imshow('sample02', img2)

    # 画像の乗算
    src1 = cv2.multiply(img1, img2)
    cv2.imshow('sample03', src1)

    cv2.waitKey(0)
    cv2.destroyAllWindows()

except FileNotFoundError as e:
    print(e)
