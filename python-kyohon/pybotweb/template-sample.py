from bottle import template

response = template('こんにちは {{name}} さん', name='たろう')
print(response)
response = template('こんにちは {{name}} さん', name='じろう')
print(response)

