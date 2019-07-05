# -*- coding: utf-8 -*-
import cv2

try:
    img = cv2.imread('img/sample02.png', cv2.IMREAD_COLOR)
    if img is None:
        raise FileNotFoundError('ファイルが見つかりません。')
    
    img = cv2.circle(img, (250, 250), 100, (0, 255, 0), 3)

    cv2.imshow('sample02', img)
    cv2.waitKey(0)
    cv2.destroyAllWindows()

    cv2.imwrite('img/sample03.png', img)

except FileNotFoundError as e:
    print(e)
