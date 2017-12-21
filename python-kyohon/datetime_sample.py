from datetime import date, datetime

today = date.today()
print(today)

now = datetime.now()
print(now)

day = date(2017, 1, 1)
print(day)

print(day.weekday())
weekday_str = '月火水木金土日'
print(weekday_str[day.weekday()])

