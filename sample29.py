# -*- coding: utf-8 -*-
import cv2

try:
    img = cv2.imread('img/gradient1.png', cv2.IMREAD_COLOR)
    if img is None:
        raise FileNotFoundError('ファイルが見つかりません。')
    
    cv2.imshow('sample01', img)

    # しきい値より大きい方を最大に、小さい方を0にする
    ret, dst = cv2.threshold(img, 127, 255, cv2.THRESH_BINARY)
    cv2.imshow('sample02', dst)

    # しきい値より大きい方を0に、小さい方を最大にする
    ret, dst = cv2.threshold(img, 127, 255, cv2.THRESH_BINARY_INV)
    cv2.imshow('sample03', dst)

    # しきい値より大きい方をしきい値と同じに、他はそのまま
    ret, dst = cv2.threshold(img, 127, 255, cv2.THRESH_TRUNC)
    cv2.imshow('sample04', dst)

    # しきい値より小さい方を0に、他はそのまま
    ret, dst = cv2.threshold(img, 127, 255, cv2.THRESH_TOZERO)
    cv2.imshow('sample05', dst)

    # しきい値より大きい方を0に、他はそのまま
    ret, dst = cv2.threshold(img, 127, 255, cv2.THRESH_TOZERO_INV)
    cv2.imshow('sample06', dst)

    cv2.waitKey(0)
    cv2.destroyAllWindows()

except FileNotFoundError as e:
    print(e)
