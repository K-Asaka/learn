# -*- coding: utf-8 -*-
import cv2
import numpy as np

try:
    img = cv2.imread('img/sample04.jpg', cv2.IMREAD_COLOR)
    if img is None:
        raise FileNotFoundError('ファイルが見つかりません。')
    
    cv2.imshow('sample04.jpg', img)

    # アパーチャサイズは3
    medi1 = median = cv2.medianBlur(img, 3)
    cv2.imshow('sample04.jpg/3', medi1)

    # アパーチャサイズは5
    medi5 = median = cv2.medianBlur(img, 5)
    cv2.imshow('sample04.jpg/5', medi5)

    cv2.waitKey(0)
    cv2.destroyAllWindows()

except FileNotFoundError as e:
    print(e)
