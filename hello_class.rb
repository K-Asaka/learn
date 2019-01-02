class HelloWorld                    # class文
    attr_accessor :name
    def initialize(myname = "Ruby") # initializeメソッド
        @name = myname              # インスタンス変数の初期化
    end

    def hello                       # インスタンスメソッド
        puts "Hello, world. I am #{@name}."
    end
=begin
    def name                        # @nameを参照する
        @name
    end

    def name=(value)                # @nameを変更する
        @name = value
    end
=end
end

bob = HelloWorld.new("Bob")
alice = HelloWorld.new("Alice")
ruby = HelloWorld.new

bob.hello()

p bob.name
bob.name = "Robert"
p bob.name

