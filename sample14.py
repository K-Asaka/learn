# -*- coding: utf-8 -*-
import cv2

try:
    img = cv2.imread('img/sample01.jpg', cv2.IMREAD_COLOR)
    if img is None:
        raise FileNotFoundError('ファイルが見つかりません。')
    
    cv2.imshow('sample01', img)

    width = img.shape[1]
    height = img.shape[0]

    # デフォルトのバイリニアで2倍のサイズにする
    dst1 = cv2.resize(img, (width * 2, height * 2))
    cv2.imshow('sample02', dst1)

    # デフォルトのバイリニアで半分のサイズにする
    dst2 = cv2.resize(img, (int(width / 2), int(height / 2)))

    cv2.imshow('sample03', dst2)
    cv2.waitKey(0)
    cv2.destroyAllWindows()

except FileNotFoundError as e:
    print(e)
