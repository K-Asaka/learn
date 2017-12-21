from bottle import route, run, template, request
from datetime import datetime

@route('/hello')
def hello():
    now = datetime.now()
    return template('pybot_template', text='')

@route('/hello', method='POST')
def do_hello():
    input_text = request.forms.input_text
    return template('pybot_template', text=input_text)

run(host='localhost', port=8080, debug=True)

