def dice
    Random.rand(6) + 1
end

def dice10
    ret = 0
    10.times do
        ret += dice
    end
    ret
end

print "dice: ", dice, "\n"
print "dice10: ", dice10, "\n"
