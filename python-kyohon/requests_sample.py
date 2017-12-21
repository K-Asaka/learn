import requests

r = requests.get('http://localhost/')
print(r.status_code)

