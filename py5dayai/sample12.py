import urllib.request
import re

res = urllib.request.urlopen('http://weather.nikkei.com/yoho/')
html = res.read().decode('utf-8')
res.close()

match = re.findall('<td align="center" bgcolor="#dbf1ff" class="fs10constant">岡山</td>(.*?)</td>', html, re.DOTALL)
print(match[0])
