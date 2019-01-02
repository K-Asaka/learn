module M
    def meth
        "meth"
    end
end

class C
    include M       # モジュールMをインクルードする
end

c = C.new
p c.meth
# includeされているかを調べる
p C.include?(M)
