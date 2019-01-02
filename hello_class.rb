class HelloWorld                    # class文
    attr_accessor :name
    def initialize(myname = "Ruby") # initializeメソッド
        @name = myname              # インスタンス変数の初期化
    end

    def hello                       # インスタンスメソッド
        puts "Hello, world. I am #{@name}."
    end

    def greet
        puts "Hi, I am #{self.name}."
    end

    def test_name
        name = "Ruby"               # ローカル変数への代入
        self.name = "Ruby"          # name=メソッドの呼び出し
    end

    # クラスメソッドの定義
    #class << self
        def self.hello(name)
            puts "#{name} said hello."
        end
    #end
=begin
    def name                        # @nameを参照する
        @name
    end

    def name=(value)                # @nameを変更する
        @name = value
    end
=end
end

=begin
# このクラス定義の中にインスタンスメソッドの形式で記述するメソッドが
# クラスメソッドになる
# この書き方のクラスを「特異クラス定義」という
class << HelloWorld
    def hello(name)
        puts "#{name} said hello."
    end
end
=end

bob = HelloWorld.new("Bob")
alice = HelloWorld.new("Alice")
ruby = HelloWorld.new

bob.hello()

p bob.name
bob.name = "Robert"
p bob.name
bob.greet
bob.test_name
bob.greet
HelloWorld.hello("ClassMethod")
