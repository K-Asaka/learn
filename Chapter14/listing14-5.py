from socketserver import TCPServer, ThreadingMixIn, StreamRequestHandler

class Server(ThreadingMixIn, TCPServer): pass

class Handler(StreamRequestHandler):

    def handle(self):
        addr = self.request.getpeername()
        print('接続受付:', addr)
        self.wfile.write(bytes('接続ありがとうございます', 'utf-8'))

server = Server(('', 1234), Handler)
server.serve_forever()
