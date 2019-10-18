# httpパッケージのclientモジュールを取り込む(from利用)
from http import client
conn = client.HTTPConnection('www.python.org')
