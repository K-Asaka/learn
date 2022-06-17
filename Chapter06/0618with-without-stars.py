def with_stars(**kwds):
    print(f"{kwds['name']}は{kwds['age']}歳です。")
def without_stars(kwds):
    print(f"{kwds['name']}は{kwds['age']}歳です。")

args = {'name': '太郎', 'age': 42}

with_stars(**args)
without_stars(args)
