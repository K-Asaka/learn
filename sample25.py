# -*- coding: utf-8 -*-
import cv2
import numpy as np

try:
    img1 = cv2.imread('img/sample05.jpg', cv2.IMREAD_COLOR).astype(np.float32) / 255
    if img1 is None:
        raise FileNotFoundError('ファイルが見つかりません。')
    
    img2 = cv2.imread('img/sample06.jpg', cv2.IMREAD_COLOR).astype(np.float32) / 255
    if img2 is None:
        raise FileNotFoundError('ファイルが見つかりません。')
    
    weight1 = cv2.imread('img/gradient1.png', cv2.IMREAD_COLOR).astype(np.float32) / 255
    if weight1 is None:
        raise FileNotFoundError('ファイルが見つかりません。')

    cv2.imshow('sample01', img1)
    cv2.imshow('sample02', weight1)
    src1 = cv2.multiply(img1, weight1)
    cv2.imshow('sample03', src1)
    cv2.imshow('sample04', img2)

    # もう一つの画像に逆の重みを付ける
    weight2 = 1.0 - weight1
    cv2.imshow('sample05', weight2)
    src2 = cv2.multiply(img2, weight2)
    cv2.imshow('sample06', src2)

    dst = cv2.add(src1, src2)
    cv2.imshow('sample07', dst)

    cv2.waitKey(0)
    cv2.destroyAllWindows()

except FileNotFoundError as e:
    print(e)
