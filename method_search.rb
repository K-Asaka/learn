module M1
    def meth
        "M#meth"
    end
end

module M2
    def meth
        "M#meth"
    end
end

class C
    include M1       # M1をインクルードする
    include M2       # M2をインクルードする
end

p C.ancestors
