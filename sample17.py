# -*- coding: utf-8 -*-
import cv2

try:
    img = cv2.imread('img/sample04.jpg', cv2.IMREAD_COLOR)
    if img is None:
        raise FileNotFoundError('ファイルが見つかりません。')
    
    cv2.imshow('sample01', img)

    # 0.1倍にする
    size = (int(img.shape[1] / 10), int(img.shape[0] / 10))

    # 縮小
    dst1 = cv2.resize(img, size, interpolation=cv2.INTER_NEAREST)

    # 元のサイズに戻す
    dst2 = cv2.resize(dst1, (img.shape[1], img.shape[0]), interpolation=cv2.INTER_NEAREST)

    cv2.imshow('sample02', dst2)
    cv2.waitKey(0)
    cv2.destroyAllWindows()

except FileNotFoundError as e:
    print(e)
