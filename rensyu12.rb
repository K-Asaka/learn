def my_collect(obj, &block)
    buf = []
    obj.each do |elem|
        buf << block.call(elem)
    end
    buf
end

ary = my_collect([1, 2, 3, 4, 5]) do |i|
    i * 2
end

p ary


to_class = :class.to_proc
p to_class.call("test")
p to_class.call(123)
p to_class.call(2 ** 100)

def accumlator
    total = 0
    Proc.new do |x|
        total += x
    end
end

acc = accumlator
p acc.call(1)
p acc.call(2)
p acc.call(3)
p acc.call(4)
