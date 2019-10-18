# httpパッケージのclientモジュールを取り込む
import http.client
conn = http.client.HTTPConnection('www.python.org')
print(conn)
