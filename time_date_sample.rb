p Time.new
sleep 1
p Time.now

t = Time.now
p t
p t.year
p t.month
p t.day

t = Time.mktime(2015, 9, 25, 3, 45, 15)
p t

t0 = Time.at(0)
p t0

t1 = Time.at(1500000000)
p t1

t1 = Time.new
sleep(10)
t2 = Time.now
p t1 < t2
p t2 - t1

t = Time.now
p t
t2 = t + 60 * 60 * 24
p t2

t = Time.now
p t.to_s
p t.strftime("%Y-%m-%d %H:%M:%S %z")

require "time"
t = Time.now
p t.rfc2822
p t.iso8601

t = Time.now
p t
t.utc
p t
t.localtime
p t

# require "time"
p Time.parse("Fri Sep 25 02:45:15 UTC 2015")
p Time.parse("Fri, 25 Sep 2015 02:45:15 +0900")
p Time.parse("2015/09/25")
p Time.parse("2015/09/25 02:45:15")
p Time.parse("H27.09.25")

# require "time"
p Time.strptime("平成27年9月1日", "平成%Y年%m月%d日") do |y|
    y + 1988
end

p Time.strptime("9/1/2015", "%m/%d/%Y")
p Time.strptime("1/9/2015", "%d/%m/%Y")

require "date"
d = Date.today
puts d

# require "date"
d = Date.today
p d.year
p d.month
p d.day
p d.wday
p d.mday
p d.yday

# require "date"
d = Date.new(2015, 9, 25)

# require "date"
d = Date.new(2015, 2, -1)
puts d

d = Date.new(2016, 2, -1)
puts d

# require "date"
d1 = Date.new(2015, 1, 1)
d2 = Date.new(2015, 1, 4)
puts d2 - d1

d = Date.today
p d
p d + 1
p d + 100
p d - 1
p d - 100

# require "date"
d = Date.new(2015, 1, 31)
puts d
puts d >> 1
puts d >> 2
puts d << 1
puts d << 2

# require "date"
t = Date.today
p t.strftime("%Y/%m/%d %H:%M:%S")
p t.strftime("%a %b %d %H:%M:%S %Z %Y")
p t.iso8601
p t.to_s

# require "date"
puts Date.parse("Fri Sep 25 03:50:12 JST 2015")
puts Date.parse("H27.09.25")
puts Date.parse("S48.9.28")
puts Date.strptime("25/9/2015", "%d/%m/%Y")

# require "date"
t1 = Time.now
p t1
d = t1.to_date
puts d
t2 = d.to_time
p t2
