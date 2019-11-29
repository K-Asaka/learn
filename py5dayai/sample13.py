import urllib.request
import re

res = urllib.request.urlopen('http://weather.nikkei.com/yoho/')
html = res.read().decode('utf-8')
res.close()

match = re.findall('<td align="center" bgcolor="#dbf1ff" class="fs10constant">岡山</td>(.*?)</td>', html, re.DOTALL)
yoho = re.findall('alt="(.*)"', match[0])
print('今日の岡山は', yoho[0])
