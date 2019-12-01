import qrcode

file_name = 'py5dayai/img/qr.png'
qr_data = 'ツブ貝,2019年11月30日,北海道'
image = qrcode.make(qr_data)

image.save(file_name)
print('ファイル名: ', file_name)
print('データ: ', qr_data)
print('QRコードを作成しました。')
