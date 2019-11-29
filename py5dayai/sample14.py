import urllib.request
import json

url = 'http://weather.livedoor.com/forecast/webservice/json/v1?city=140020'
res = urllib.request.urlopen(url)
json_data = res.read().decode('utf-8')
odawara = json.loads(json_data)
print(odawara)
