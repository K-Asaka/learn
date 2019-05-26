monk_fish_team = [158, 157, 163, 157, 145]
total = sum(monk_fish_team)
length = len(monk_fish_team)
mean = total / length

# for height in monk_fish_team:
#   variance = variance + (height - mean) ** 2
# variance = variance / length
variance = sum([(height - mean ) ** 2 for height in monk_fish_team]) / length
print(variance)
