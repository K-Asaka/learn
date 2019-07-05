# -*- coding: utf-8 -*-
import cv2

try:
    img = cv2.imread('img/sample012.jpg', cv2.IMREAD_COLOR)
    if img is None:
        raise FileNotFoundError('ファイルが見つかりません。')
    cv2.imshow('sample01', img)
    cv2.waitKey(0)
    cv2.destroyAllWindows()

except FileNotFoundError as e:
    print(e)
