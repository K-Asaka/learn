# -*- coding: utf-8 -*-
import cv2
import numpy as np

try:
    img = cv2.imread('img/sample04.jpg', cv2.IMREAD_COLOR)
    if img is None:
        raise FileNotFoundError('ファイルが見つかりません。')
    
    rows, cols, ch = img.shape

    # 元画像の座標
    pts1 = np.float32([[0, 0], [cols, 0], [0, rows], [cols, rows]])
    # 変換後の座標
    pts2 = np.float32([[(0 + 100), 0], [(cols - 100), 0], [0, rows], [cols, rows]])

    # 透視変換行列を求める
    M = cv2.getPerspectiveTransform(pts1, pts2)
    # 透視変換
    dst = cv2.warpPerspective(img, M, (cols, rows))

    cv2.imshow('sample02', dst)

    cv2.waitKey(0)
    cv2.destroyAllWindows()

except FileNotFoundError as e:
    print(e)
