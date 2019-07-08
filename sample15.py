# -*- coding: utf-8 -*-
import cv2

try:
    img = cv2.imread('img/sample01.jpg', cv2.IMREAD_COLOR)
    if img is None:
        raise FileNotFoundError('ファイルが見つかりません。')
    
    cv2.imshow('sample01', img)

    # 2分の1倍にする
    size = (int(img.shape[1] / 2), int(img.shape[0] / 2))

    # 最近傍補間
    dst1 = cv2.resize(img, size, interpolation=cv2.INTER_NEAREST)
    cv2.imshow('sample02', dst1)

    # ピクセル領域の関係
    dst2 = cv2.resize(img, size, interpolation=cv2.INTER_AREA)
    cv2.imshow('sample03', dst2)

    # バイキュービック
    dst3 = cv2.resize(img, size, interpolation=cv2.INTER_CUBIC)
    cv2.imshow('sample04', dst3)

    # ランツォシュ
    dst4 = cv2.resize(img, size, interpolation=cv2.INTER_LANCZOS4)
    cv2.imshow('sample05', dst4)

    cv2.waitKey(0)
    cv2.destroyAllWindows()

except FileNotFoundError as e:
    print(e)
