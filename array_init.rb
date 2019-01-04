a = Array.new(3, [0, 0, 0])
p a
a[0][1] = 2
p a

a = Array.new(3) do 
    [0, 0, 0]
end
p a

a[0][1] = 2
p a
