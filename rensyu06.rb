wday = {
    sunday: "日曜日",
    monday: "月曜日",
    tuesday: "火曜日",
    wedensday: "水曜日",
    thursday: "木曜日",
    friday: "金曜日",
    saturday: "土曜日",
}

p wday[:sunday]
p wday[:monday]
p wday[:saturday]

p wday.size

wday = {
    "sunday" => "日曜日",
    "monday" => "月曜日",
    "tuesday" => "火曜日",
    "wedensday" => "水曜日",
    "thursday" => "木曜日",
    "friday" => "金曜日",
    "saturday" => "土曜日",
}

%w(sunday monday tuesday wedensday thursday friday saturday).each do |day|
    puts "「#{day}」は#{wday[day]}のことです。"
end

def str2hash(str)
    hash = Hash.new
    array = str.split(/\s+/)
    while key = array.shift
        value = array.shift
        hash[key] = value
    end
    return hash
end

p str2hash("bule 青 white 白\nred 赤")
