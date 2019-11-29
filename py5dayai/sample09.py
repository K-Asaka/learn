import datetime as dt
from dateutil.relativedelta import relativedelta

day = dt.date(2020, 2, 1) + relativedelta(day=99)
print('2020年2月の月末は{}日です。'.format(day.day))
