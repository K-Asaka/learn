# -*- coding: utf-8 -*-
import cv2

try:
    img = cv2.imread('img/sample01.jpg', cv2.IMREAD_COLOR)
    if img is None:
        raise FileNotFoundError('ファイルが見つかりません。')
    
    blue, green, red = cv2.split(img)
    cv2.imshow('sample01.jpg/blue', blue)
    cv2.imshow('sample01.jpg/green', green)
    cv2.imshow('sample01.jpg/red', red)

    cv2.waitKey(0)
    cv2.destroyAllWindows()

except FileNotFoundError as e:
    print(e)
