import cv2
import numpy as np

try:
    img = cv2.imread('py5dayai/img/sample01.jpg')
    if img is None:
        raise FileNotFoundError('ファイルが見つかりません')

    rows, cols, ch = img.shape

    pts1 = np.float32([[0, 0], [cols, 0], [0, rows], [cols, rows]])
    pts2 = np.float32([[(0 + 100), 0], [(cols - 100), 0], [0, rows], [cols, rows]])

    M = cv2.getPerspectiveTransform(pts1, pts2)
    dst = cv2.warpPerspective(img, M, (cols, rows))

    cv2.imshow('sample02', dst)

    cv2.waitKey(0)
    cv2.destroyAllWindows()

except FileNotFoundError as e:
    print(e)
