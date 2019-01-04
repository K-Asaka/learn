def cels_to_fahr(celsius)
    celsius * 9.0 / 5.0 + 32.0
end

def fahr_to_cels(fahrenheit)
    (fahrenheit.to_f - 32) * 5.0 / 9.0
end

p cels_to_fahr(20)
1.upto(100) do |i|
    print i, " ", fahr_to_cels(i), "\n"
end
