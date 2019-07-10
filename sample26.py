# -*- coding: utf-8 -*-
import cv2

try:
    img1 = cv2.imread('img/sample05.jpg', cv2.IMREAD_COLOR)
    if img1 is None:
        raise FileNotFoundError('ファイルが見つかりません。')
    
    img2 = cv2.imread('img/sample06.jpg', cv2.IMREAD_COLOR)
    if img2 is None:
        raise FileNotFoundError('ファイルが見つかりません。')
    
    addW1 = cv2.cv2.addWeighted(img1, 0.2, img2, 0.7, 0.0)
    cv2.imshow('sample01', addW1)

    addW2 = cv2.cv2.addWeighted(img1, 0.5, img2, 0.5, 0.0)
    cv2.imshow('sample02', addW2)

    addW3 = cv2.cv2.addWeighted(img1, 0.7, img2, 0.2, 0.0)
    cv2.imshow('sample03', addW3)

    cv2.waitKey(0)
    cv2.destroyAllWindows()

except FileNotFoundError as e:
    print(e)
