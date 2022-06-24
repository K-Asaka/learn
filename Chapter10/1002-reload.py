import sys
sys.path.append('D:\devel\python\learn\Chapter10\module')
import hello
import importlib
hello = importlib.reload(hello)
