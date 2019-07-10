# -*- coding: utf-8 -*-
import cv2
import numpy as np

try:
    img1 = cv2.imread('img/sample05.jpg', cv2.IMREAD_ANYCOLOR)
    if img1 is None:
        raise FileNotFoundError('ファイルが見つかりません。')
    
    img2 = cv2.imread('img/sample06.jpg', cv2.IMREAD_COLOR)
    if img2 is None:
        raise FileNotFoundError('ファイルが見つかりません。')

    img_mask = np.zeros((480, 640), np.uint8)


    # マスクの作成
    img_mask = cv2.circle(img_mask, (120, 240), 60, (255, 255, 255), -1)
    triangle = np.array([[300, 180], [220, 300], [380, 300]])
    img_mask = cv2.fillConvexPoly(img_mask, triangle, (255, 255, 255))
    rectangle = np.array([[440, 180], [440, 300], [560, 300], [560, 180]])
    img_mask = cv2.fillConvexPoly(img_mask, rectangle, (255, 255, 255))

    # マスクを使って加算
    add1 = cv2.add(img1, img2, dst=img1, mask=img_mask)
    cv2.imshow('sample01', add1)

    cv2.waitKey(0)
    cv2.destroyAllWindows()

except FileNotFoundError as e:
    print(e)
