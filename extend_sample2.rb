module ClassMethods     # クラスメソッドのためのモジュール
    def cmethod
        "class method"
    end
end

module InstanceMethods  # インスタンスメソッドのためのモジュール
    def imethod
        "instance method"
    end
end

class MyClass
    # extendするとクラスメソッドを追加できる
    extend ClassMethods
    # includeするとインスタンスメソッドを追加できる
    include InstanceMethods
end

p MyClass.cmethod
p MyClass.new.imethod
