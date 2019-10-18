# 練習問題7-4(1)
nums = list()
for n in range(3):
    data = int(input('{}個目の整数を入力してください >>'.format(n + 1)))
    nums.append(data)
print(max(nums))
