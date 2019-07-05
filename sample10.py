# -*- coding: utf-8 -*-
import cv2
import numpy as np

try:
    img = cv2.imread('img/sample01.jpg', cv2.IMREAD_COLOR)
    if img is None:
        raise FileNotFoundError('ファイルが見つかりません。')
    
    cv2.imshow('sample01.jpg', img)

    blur = cv2.blur(img, (5, 5))    # カーネルサイズ5x5

    cv2.imshow('sample01.jpg/blur', blur)

    cv2.waitKey(0)
    cv2.destroyAllWindows()

except FileNotFoundError as e:
    print(e)
