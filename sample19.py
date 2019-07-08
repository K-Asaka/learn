# -*- coding: utf-8 -*-
import cv2

try:
    img = cv2.imread('img/sample04.jpg', cv2.IMREAD_COLOR)
    if img is None:
        raise FileNotFoundError('ファイルが見つかりません。')
    
    cv2.imshow('sample01', img)

    center = (img.shape[1] / 2, img.shape[0] / 2)
    size = (img.shape[1], img.shape[0])

    # 45度
    rotat = cv2.getRotationMatrix2D(center, 45.0, 1.0)
    dst = cv2.warpAffine(img, rotat, size, flags=cv2.INTER_CUBIC)
    cv2.imshow('sample02', dst)

    # 135度
    rotat = cv2.getRotationMatrix2D(center, 135.0, 1.0)
    dst = cv2.warpAffine(img, rotat, size, flags=cv2.INTER_CUBIC)
    cv2.imshow('sample02', dst)

    # 225度
    rotat = cv2.getRotationMatrix2D(center, 225.0, 1.0)
    dst = cv2.warpAffine(img, rotat, size, flags=cv2.INTER_CUBIC)
    cv2.imshow('sample04', dst)

    # 315度
    rotat = cv2.getRotationMatrix2D(center, 315.0, 1.0)
    dst = cv2.warpAffine(img, rotat, size, flags=cv2.INTER_CUBIC)
    cv2.imshow('sample05', dst)

    cv2.waitKey(0)
    cv2.destroyAllWindows()

except FileNotFoundError as e:
    print(e)
