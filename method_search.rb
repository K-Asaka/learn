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

module M3
    include M2      # M2をインクルードする
end

class C
    include M1       # M1をインクルードする
    include M3       # M3をインクルードする
end

p C.ancestors
