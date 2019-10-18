# Flaskを使って現在時刻を表示する
from flask import Flask
import datetime

app = Flask(__name__)
@app.route('/')
def hello():
    dt = datetime.datetime.now()
    html = '<!DOCTYPE html>'
    html += '<html>'
    html += '<head><title>Flask Sample</title></head>'
    html += '<body>'
    html += '{}年{}月{}日 {}時{}分{}秒です'.format(dt.year, dt.month, dt.day, dt.hour, dt.minute, dt.second)
    html += '</body></html>'
    return html

if __name__ == '__main__':
    app.run()
