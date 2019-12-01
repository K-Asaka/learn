import cv2

try:
    img = cv2.imread('py5dayai/img/qr.png')
    if img is None:
        raise FileNotFoundError('ファイルが見つかりません。')

    detector = cv2.QRCodeDetector()
    retval, points, straight_qrcode = detector.detectAndDecode(img)
    print(retval)

except FileNotFoundError as e:
    print(e)

