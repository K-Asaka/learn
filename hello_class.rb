class HelloWorld                    # class文
    def initialize(myname = "Ruby") # initializeメソッド
        @name = myname              # インスタンス変数の初期化
    end

    def hello                       # インスタンスメソッド
        puts "Hello, world. I am #{@name}."
    end

    def name                        # @nameを参照する
        @name
    end

    def name=(value)                # @nameを変更する
        @name = value
    end

end

bob = HelloWorld.new("Bob")
alice = HelloWorld.new("Alice")
ruby = HelloWorld.new

bob.hello()

p bob.name
bob.name = "Robert"
p bob.name

