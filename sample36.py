# -*- coding: utf-8 -*-
import cv2

try:
    img = cv2.imread('img/sample07.jpg', cv2.IMREAD_COLOR)
    if img is None:
        raise FileNotFoundError('ファイルが見つかりません。')
    
    # 顔認証用のXMLファイル
    # 環境に応じてパスを書き換える
    filename = 'haarcascade_eye.xml'
    cascade = cv2.CascadeClassifier(filename)
    if cascade is None:
        raise FileNotFoundError('ファイルが見つかりません。')
    
    # 顔の検出
    face = cascade.detectMultiScale(img)

    if len(face) > 0:
        for r in face:
            x, y = r[0:2]
            width, height = r[0:2] + r[2:4]
            # 検出した部分に四角形を描く
            cv2.rectangle(img, (x, y), (width, height), (255, 255, 255), thickness=2)
    else:
        print('顔が見つかりません')

    # 画像データが大きいと表示しきれないのでファイルに保存する
    cv2.imwrite('img/dobj.jpg', img)
    cv2.imshow('sample01', img)

    cv2.waitKey(0)
    cv2.destroyAllWindows()

except FileNotFoundError as e:
    print(e)
