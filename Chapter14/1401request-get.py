import requests
webpage = requests.get("https://www.python.org")

print(f"ステータスコード={webpage.status_code}")
print(f"エンコーディング={webpage.encoding}")
print(f"コンテントのタイプ={webpage.headers['content-type']}")
print(f"コンテントの長さ={webpage.headers['Content-Length']}")

html = webpage.text
print(f"----- HTMLコード(先頭部分100文字)\n{html[0:100]}")

import re
pattern = re.compile(r'<a href="([^"]+)', re.MULTILINE)

match = re.search('<a href="([^"]+)" .*?>about</a>', html, re.IGNORECASE)

print(f"\nABOUTページのURL={match.group(1)}")

match = re.search('(<body (.|\s)*</body>)', html, re.IGNORECASE)

print("\n----- <body>部の先頭100文字 -----");
print(f"{match.group(1)[0:100]}")

print("\n----- <body>部の最後の100文字 -----");
print(f"{match.group(1)[-100:]}")
