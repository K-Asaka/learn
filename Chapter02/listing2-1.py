# 年月日を数値で指定すると英語の表記で出力する
months = [
    'January',
    'February',
    'March',
    'April',
    'May',
    'June',
    'July',
    'August',
    'September',
    'October',
    'November',
    'December'
]

# 英語の日付の終わりに付く序数を表す接尾辞
endings = ['st', 'nd', 'rd'] + 17 * ['th'] \
        + ['st', 'nd', 'rd'] +  7 * ['th'] \
        + ['st']

year  = input('年: ')
month = input('月(1-12): ')
day   = input('日(1-31): ')

month_number = int(month)
day_number = int(day)

# リストのインデックスは0から始まるので「-1」が必要
month_name = months[month_number-1]
ordinal = day + endings[day_number-1]

print(month_name + ' ' + ordinal + ', ' + year)
