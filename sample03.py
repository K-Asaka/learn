# -*- coding: utf-8 -*-
import cv2

try:
    img = cv2.imread('img/sample02.png', cv2.IMREAD_COLOR)
    if img is None:
        raise FileNotFoundError('ファイルが見つかりません。')

    img = cv2.putText(img, 'Nikkei Software', (100, 50), cv2.FONT_HERSHEY_SIMPLEX, 1, (0, 255.0), 1)
    img = cv2.putText(img, 'Nikkei Software', (100, 100), cv2.FONT_HERSHEY_PLAIN, 1, (0, 255.0), 1)
    img = cv2.putText(img, 'Nikkei Software', (100, 150), cv2.FONT_HERSHEY_DUPLEX, 1, (0, 255.0), 1)
    img = cv2.putText(img, 'Nikkei Software', (100, 200), cv2.FONT_HERSHEY_COMPLEX, 1, (0, 255.0), 1)
    img = cv2.putText(img, 'Nikkei Software', (100, 250), cv2.FONT_HERSHEY_TRIPLEX, 1, (0, 255.0), 1)
    img = cv2.putText(img, 'Nikkei Software', (100, 300), cv2.FONT_HERSHEY_COMPLEX_SMALL, 1, (0, 255.0), 1)
    img = cv2.putText(img, 'Nikkei Software', (100, 350), cv2.FONT_HERSHEY_SCRIPT_SIMPLEX, 1, (0, 255.0), 1)
    img = cv2.putText(img, 'Nikkei Software', (100, 400), cv2.FONT_HERSHEY_SCRIPT_COMPLEX, 1, (0, 255.0), 1)

    cv2.imshow('sample03', img)
    cv2.waitKey(0)
    cv2.destroyAllWindows()

except FileNotFoundError as e:
    print(e)
