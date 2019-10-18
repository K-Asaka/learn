# 標準ライブラリを利用したWebページの取得
import http.client
conn = http.client.HTTPConnection('www.python.org')
conn.request('GET', '/downloads/')
response = conn.getresponse()
text = response.read().decode('UTF-8')
print(text)
conn.close()
