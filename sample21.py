# -*- coding: utf-8 -*-
import cv2

try:
    img1 = cv2.imread('img/sample05.jpg', cv2.IMREAD_COLOR)
    if img1 is None:
        raise FileNotFoundError('ファイルが見つかりません。')
    img2 = cv2.imread('img/sample06.jpg', cv2.IMREAD_COLOR)
    if img2 is None:
        raise FileNotFoundError('ファイルが見つかりません。')
    
    # 2つの画像の加算
    add56 = cv2.add(img1, img2)
    cv2.imshow('sample56', add56)

    cv2.waitKey(0)
    cv2.destroyAllWindows()

except FileNotFoundError as e:
    print(e)
