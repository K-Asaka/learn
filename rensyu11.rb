require "date"

class Person
    attr_reader :birth_date

    # Person.new でキーワード引数で生年月日を受け取る
    def initialize(birth_date: )
        @birth_date = birth_date
    end

    # ある日付の年齢を返す。日付を指定されない場合は今日の年齢になる。
    def age(date=Date.today)
        # 生まれる前なら -1 を返す (エラーケース)
        return -1 if date < birth_date

        # 年数を計算する
        years = date.year - birth_date.year

        if date.month < birth_date.month
            # 誕生月の前なら1引く
            years -= 1
        elsif date.month == birth_date.month && date.day < birth_date.day
            # 誕生月と同月で誕生日の前なら1引く
            years -= 1
        end
        return years
    end
end

ruby = Person.new(birth_date: Date.new(1993, 2, 24))
p ruby.birth_date
p ruby.age
p ruby.age(Date.new(2013, 2, 23))
p ruby.age(Date.new(2013, 2, 24))
p ruby.age(Date.new(1988, 2, 24))


def jparsedate(str)
    now = Time.now
    year = now.year
    month = now.month
    day = now.day
    hour = now.hour
    min = now.min
    sec = now.sec
    str.scan(/(午前|午後)?(\d+)(年|月|日|時|分|秒)/) do 
        case $3
        when "年"
            year = $2.to_i
        when "月"
            month = $2.to_i
        when "日"
            day = $2.to_i
        when "時"
            hour = $2.to_i
            hour += 12 if $1 == "午後"
        when "分"
            min = $2.to_i
        when "秒"
            sec = $2.to_i
        end
    end
    return Time.mktime(year, month, day, hour, min, sec)
end

p jparsedate("2010年12月23日午後8時17分50秒")
p jparsedate("12月23日午後8時17分50秒")
p jparsedate("午前8時17分50秒")
p jparsedate("8時17分50秒")

def ls_t(path)
    entries = Dir.entries(path)
    entries.reject!{|name| /^\./ =~ name }

    mtimes = Hash.new

    entries = entries.sort_by do |name|
        mtimes[name] = File.mtime(File.join(path, name))
    end

    entries.each do |name|
        printf("%-40s %s\n", name, mtimes[name])
    end
rescue => ex
    puts ex.message
end

ls_t(ARGV[0] || ".")


require "Date"

module Calendar
    WEEK_TABLE = [
        [99, 99, 99, 99, 99, 99,  1,  2,  3,  4,  5,  6,  7],
        [ 2,  3,  4,  5,  6,  7,  8,  9, 10, 11, 12, 13, 14],
        [ 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21],
        [16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28],
        [23, 24, 25, 26, 27, 28, 29, 30, 31, 99, 99, 99, 99],
        [30, 31, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99],
    ]

    module_function

    def cal(year, month)
        first = Date.new(year, month, 1)
        end_of_month = ((first >> 1) - 1).day
        start = 6 - first.wday
        
        puts first.strftime("%B %Y").center(21)
        puts " Su Mo Tu We Th Fr St"
        WEEK_TABLE.each do |week|
            buf = ""
            week[start, 7].each do |day|
                if day > end_of_month
                    buf << "   "
                else
                    buf << sprintf("%3d", day)
                end
            end
            puts buf
        end
    end
end

if arg = ARGV.first
    d = Date.parse(arg)
else
    d = Date.today
end
Calendar.cal(d.year, d.month)
