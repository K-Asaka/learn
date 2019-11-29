import cv2

try:
    img = cv2.imread('py5dayai/img/sample01.jpg')
    if img is None:
        raise FileNotFoundError('ファイルが見つかりません')

    cv2.imshow('sample01', img)
    cv2.waitKey(0)
    cv2.destroyAllWindows()

except FileNotFoundError as e:
    print(e)
