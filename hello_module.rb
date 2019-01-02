module HelloModule          # module文
    Version = "1.0"         # 定数の定義

    def hello(name)         # メソッドの定義
        puts "Hello, #{name}."
    end
    module_function :hello  # helloをモジュール関数として公開する
end

p HelloModule::Version
HelloModule.hello("Alice")

include HelloModule         # インクルードしてみる
p Version
hello("Alice")
