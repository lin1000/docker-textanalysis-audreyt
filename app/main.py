from flask import Flask, send_file, render_template
import socket
import jinja2
import os


app = Flask(__name__)

@app.route("/hello")
def hello():
    return "Hello World from Flask"

@app.route("/")
def main():
    print("accessing main")
    return render_template('index.html', container_id=socket.gethostname())

# # Everything not declared before (not a Flask route / API endpoint)...
# @app.route('/<path:path>')
# def route_frontend(path):
#     # ...could be a static file needed by the front end that 
#     # doesn't use the `static` path (like in `<script src="bundle.js">`)
#     file_path = './static/' + path
#     if os.path.isfile(file_path):
#         return send_file(file_path)
#     # ...or should be handled by the SPA's "router" in front end
#     else:
#         return render_template('index.html', container_id=socket.gethostname()) 

if __name__ == "__main__":
    app.run(host='0.0.0.0', debug=True, port=8080)
