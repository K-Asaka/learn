def conflict(state, nextX):
    nextY = len(state)
    for i in range(nextY):
        if abs(state[i] - nextX) in (0, nextY - i):
            return True
    return False

def queens(num=8, state=()):
    # if len(state) == num-1:
    #     for pos in range(num):
    #         if not conflict(state, pos):
    #             yield pos
    # else:
    #     for pos in range(num):
    #         if not conflict(state, pos):
    #             for result in queens(num, state + (pos,)):
    #                 yield (pos,) + result
    for pos in range(num):
        if not conflict(state, pos):
            if len(state) == num-1:
                yield (pos,)
            else:
                for result in queens(num, state + (pos,)):
                    yield (pos,) + result


# print(list(queens(4, (1, 3, 0))))
print(list(queens(3)))
print(list(queens(4)))
print('-----1')
count = 0
for solution in queens(8):
    count += 1
    print(solution)

print(len(list(queens(8))))


def prettyprint(solution):
    def line(pos, length=len(solution)):
        return '. ' * (pos) + 'X ' + '. ' * (length-pos-1)
    for pos in solution:
        print(line(pos))

import random
prettyprint(random.choice(list(queens(8))))
