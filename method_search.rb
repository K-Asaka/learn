module M
    def meth
        "M#meth"
    end
end

class C
    include M       # Mをインクルードする
    def meth
        "C#meth"
    end
end

c = C.new
p c.meth
