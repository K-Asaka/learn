import urllib.request
import json

url = 'http://weather.livedoor.com/forecast/webservice/json/v1?city=140020'
res = urllib.request.urlopen(url)
html = res.read().decode('utf-8')
jdata = json.loads(html)

print(jdata['title'])
print(jdata['forecasts'][0]['dateLabel'])
print(jdata['forecasts'][0]['telop'])
