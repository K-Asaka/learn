a = (1..100).to_a
p a

a2 = a.collect {|i| i * 100 }
p a2

a3 = a.reject {|i| i % 3 != 0 }
p a3

p a.reverse

sum = 0
a.each {|i| sum += i }
p sum

ary = (1..100).to_a
result = Array.new
10.times do |i|
    result << ary[i * 10, 10]
end
p result

def sum_array(ary1, ary2)
    result = Array.new
    i = 0
    ary1.each do |elem1|
        result << elem1 + ary2[i]
        i += 1
    end
    return result
end

def sum_array_zip(ary1, ary2)
    result = Array.new
    ary1.zip(ary2) {|a, b| result << a + b }
    return result
end

p sum_array([1, 2, 3], [4, 6, 8])
