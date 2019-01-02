class Point
    attr_accessor :x, :y

    def initialize(x=0, y=0)
        @x, @y = x, y
    end

    def inspect             # pメソッドで「(x, y)」と表示する
        "(#{x}, #{y})"
    end

    def +(other)            # x,yのそれぞれを足す
        self.class.new(x + other.x, y + other.y)
    end

    def -(other)            # x,yのそれぞれを引く
        self.class.new(x - other.x, y - other.y)
    end

    def +@
        dup                 # 自分の複製を返す
    end

    def -@
        self.class.new(-x, -y)      # x,yのそれぞれの正負を逆にする
    end

    def ~@
        self.class.new(-y, x)       # 90度反転させた座標を返す
    end

    def [](index)
        case index
        when 0
            x
        when 1
            y
        else
            raise ArgumentError, "out of range `#{index}`"
        end
    end

    def []=(index, val)
        case index
        when 0
            self.x = val
        when 1
            self.y = val
        else
            raise ArgumentError, "out of range `#{index}`"
        end
    end
end

point = Point.new(3, 6)

p point[0]
p point[1] = 2
p point[1]
p point[2]
