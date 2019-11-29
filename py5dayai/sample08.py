import datetime as dt

sample_date = dt.date(2019, 10, 24)
sample_timedelta = dt.timedelta(days=10)
later = sample_date + sample_timedelta
print('2019年10月24日の10日後:{}'.format(later))
