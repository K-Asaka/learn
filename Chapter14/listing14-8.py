from twisted.internet import reactor
from twisted.internet.protocol import Protocol, Factory

class SimpleLogger(Protocol):

    def connectionMade(self):
        print('接続受付:', self.transport.client)
    
    def connectionLost(self, reason):
        print(self.transport.client, '接続解除')
    
    def dataReceived(self, data):
        print(data)

factory = Factory()
factory.protocol = SimpleLogger

reactor.listenTCP(1234, factory)
reactor.run()
