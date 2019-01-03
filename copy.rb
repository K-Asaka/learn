def copy(from, to)
    src = File.open(from)          # コピー元ファイルfromを開く
    begin
        dst = File.open(to, "w")    # コピー先ファイルtoを開く
        data = src.read
        dst.write(data)
        dst.close
    ensure
        src.close
    end
end

copy(ARGV[0], ARGV[1])
