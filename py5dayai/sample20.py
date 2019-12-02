import cv2

try:
    img_name = 'py5dayai/img/face.jpg'
    xml_data = 'py5dayai/img/haarcascade_frontalface_default.xml'

    img = cv2.imread(img_name)
    if img is None:
        raise FileNotFoundError('imgファイルが見つかりません。')

    cascade = cv2.CascadeClassifier(xml_data)
    if cascade is None:
        raise FileNotFoundError('xmlファイルが見つかりません。')

    face = cascade.detectMultiScale(img)
    if len(face) > 0:
        for r in face:
            x, y = r[0:2]
            width, height = r[0:2] + r[2:4]
            cv2.rectangle(img, (x, y), (width, height), (0, 255, 0), thickness=2)
    else:
        print('顔が見つかりません。')
    
    cv2.imwrite(img_name, img)
    cv2.imshow(img_name, img)
    cv2.waitKey(0)
    cv2.destroyAllWindows()

except FileNotFoundError as e:
    print(e)

