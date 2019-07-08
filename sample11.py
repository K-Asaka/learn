# -*- coding: utf-8 -*-
import cv2
import numpy as np

try:
    img = cv2.imread('img/sample01.jpg', cv2.IMREAD_COLOR)
    if img is None:
        raise FileNotFoundError('ファイルが見つかりません。')

    # 平滑化カーネルサイズが(5,5)
    # ガウシアンカーネルのx方向の標準偏差が1.3
    gaus = cv2.GaussianBlur(img, ksize=(5,5), sigmaX=1.3)
    cv2.imshow('sample01/gaus', gaus)

    # 近傍領域の直径が9
    # 色のフィルターシグマが75
    # 座標フィルタシグマーが75
    bila = cv2.bilateralFilter(img, 9, 75, 75)
    cv2.imshow('sample01./bila', bila)

    cv2.waitKey(0)
    cv2.destroyAllWindows()

except FileNotFoundError as e:
    print(e)
