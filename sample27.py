# -*- coding: utf-8 -*-
import cv2
import numpy as np

try:
    img = np.zeros((680, 1024), np.uint8)

    # 白い円を描く
    img = cv2.circle(img, (236, 340), 100, (255, 255, 255), -1)

    # 白い三角形を描く
    triangle = np.array([[512, 240], [412, 440], [612, 440]])

    img = cv2.fillConvexPoly(img, triangle, (255, 255, 255))

    # 白い四角形を描く
    rectangle = np.array([[688, 240], [688, 440], [888, 440], [888, 240]])
    img_mask = cv2.fillConvexPoly(img, rectangle, (255, 255, 255))

    cv2.imshow('mask01', img_mask)

    cv2.waitKey(0)
    cv2.destroyAllWindows()

except FileNotFoundError as e:
    print(e)
