# -*- coding: utf-8 -*-
import cv2

try:
    # グレースケールで読み込む
    img1 = cv2.imread('img/sample01.jpg', cv2.IMREAD_GRAYSCALE)
    if img1 is None:
        raise FileNotFoundError('ファイルが見つかりません。')

    # カラー画像で読み込む
    img2 = cv2.imread('img/sample01.jpg', cv2.IMREAD_COLOR)
    if img2 is None:
        raise FileNotFoundError('ファイルが見つかりません。')
    
    print(f'img1 : {img1.shape}')
    print(f'img2 : {img2.shape}')

except FileNotFoundError as e:
    print(e)
