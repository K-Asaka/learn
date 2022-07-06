from flask import Flask
app = Flask(__name__)

@app.route('/')
# @app.route('/powers/<int:n>')
def powers(n=10):
    return ', '.join(str(2**i) for i in range(n))
