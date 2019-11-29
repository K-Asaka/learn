import urllib.request

res = urllib.request.urlopen('http://weather.nikkei.com/yoho/')
html = res.read().decode('utf-8')
res.close()

f = open('py5dayai/weather.html', 'w', encoding='utf-8')
f.write(html)
f.close()
print('weather.htmlに保存しました')
