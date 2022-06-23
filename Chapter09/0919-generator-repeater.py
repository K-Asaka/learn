def repeater(value):
    while True:
        new = (yield value)
        if new is not None: value = new


r = repeater(42)
print(next(r))
print(next(r))
print(r.send("メッセージ1"))
print(next(r))
print(r.send("メッセージ2"))
print(next(r))
