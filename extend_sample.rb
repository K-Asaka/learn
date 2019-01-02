module Edition
    def edition(n)
        "#{self} 第#{n}版"
    end
end

str = "たのしいRuby"
str.extend(Edition)     #=> モジュールをオブジェクトにMix-inする

p str.edition(5)
