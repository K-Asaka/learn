# -*- coding: utf-8 -*-
import cv2

img = cv2.imread('img/sample01.jpg', cv2.IMREAD_COLOR)
cv2.imshow('sample01', img)
cv2.waitKey(0)
cv2.destroyAllWindows()
