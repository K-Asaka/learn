from random import shuffle
from pprint import pprint

values = list(range(1, 11)) + 'J Q K'.split()
suits = '♢ ♧ ♡ ♤'.split()
deck = [f'{s} {v}' for v in values for s in suits]
pprint(deck)
shuffle(deck)
print("-----------")
pprint(deck)
