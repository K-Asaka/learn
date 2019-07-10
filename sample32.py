# -*- coding: utf-8 -*-
import cv2

try:
    img = cv2.imread('img/sample04.jpg', cv2.IMREAD_COLOR)
    if img is None:
        raise FileNotFoundError('ファイルが見つかりません。')
    
    lap1 = cv2.Laplacian(img, ddepth=-1)
    cv2.imshow('sample01', lap1)

    # 出力画像をfloat64にする
    lap2 = cv2.Laplacian(img, ddepth=cv2.CV_64F)
    cv2.imshow('sample02', lap2)

    cv2.waitKey(0)
    cv2.destroyAllWindows()

except FileNotFoundError as e:
    print(e)
