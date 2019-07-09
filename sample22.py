# -*- coding: utf-8 -*-
import cv2

try:
    img1 = cv2.imread('img/sample05.jpg', cv2.IMREAD_COLOR)
    if img1 is None:
        raise FileNotFoundError('ファイルが見つかりません。')
    
    img2 = cv2.imread('img/sample06.jpg', cv2.IMREAD_COLOR)
    if img2 is None:
        raise FileNotFoundError('ファイルが見つかりません。')
    
    #absdiff関数
    abs56 = cv2.absdiff(img1, img2)
    cv2.imshow('abs56', abs56)

    # sample05.jpg - sample06.jpg
    dst56 = img1 - img2
    cv2.imshow('5-6', dst56)

    # sample06.jpg - sample05.jpg
    dst65 = img2 - img1
    cv2.imshow('6-5', dst65)

    cv2.waitKey(0)
    cv2.destroyAllWindows()

except FileNotFoundError as e:
    print(e)
