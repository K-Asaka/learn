def uruu(year):
    res = None

    if year % 400 == 0:
        res = True
    elif year % 100 == 0:
        res = False
    elif year % 4 == 0:
        res = True
    else:
        res = False

    return res
