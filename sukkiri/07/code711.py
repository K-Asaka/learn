# httpパッケージのclientモジュールから関数だけを取り込む
from http.client import HTTPConnection
conn = HTTPConnection('www.python.org')
