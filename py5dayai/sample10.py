import urllib.request

res = urllib.request.urlopen('http://weather.nikkei.com/yoho/')
html = res.read().decode('utf-8')
res.close()
print(html)
