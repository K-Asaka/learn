def flatten(nested):
    try:
        for sublist in nested:
            for element in flatten(sublist):
                yield element
    except TypeError:
        yield nested

fl = list(flatten([[[1], 2], 3, 4, [5, [6, 7]], 8]))
print(fl)
