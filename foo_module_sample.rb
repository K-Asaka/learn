module FooModule
    def foo
        p self
    end
    module_function :foo
end

FooModule.foo
