# -*- coding: utf-8 -*-
import cv2

try:
    img = cv2.imread('img/sample04.jpg', cv2.IMREAD_GRAYSCALE)
    if img is None:
        raise FileNotFoundError('ファイルが見つかりません')
    
    can1 = cv2.Canny(img, threshold1=100, threshold2=200)
    cv2.imshow('sample01', can1)

    can2 = cv2.Canny(img, threshold1=100, threshold2=200, L2gradient=True)
    cv2.imshow('sample02', can2)

    can3 = cv2.Canny(img, threshold1=50, threshold2=100)
    cv2.imshow('sample03', can3)

    can4 = cv2.Canny(img, threshold1=50, threshold2=100, L2gradient=True)
    cv2.imshow('sample04', can4)

    cv2.waitKey(0)
    cv2.destroyAllWindows();

except FileNotFoundError as e:
    print(e)

