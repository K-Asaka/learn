def wc(file)
    nline = nword = nchar = 0
    File.open(file) do |io|
        io.each do |line|
            words = line.split(/\s+/).reject{|w| w.empty? }
            nline += 1
            nword += words.length
            nchar += line.length
        end
    end
    puts "lines=#{nline} words=#{nword} chars=#{nchar}"
end
#wc(__FILE__)

# ファイルの逆順
def reverse(input)
    open(input, "r+") do |f|
        lines = f.readlines
        f.rewind
        f.truncate(0)
        f.write lines.reverse.join()
    end
end
#reverse(ARGV[0])

# 1行先頭出力
def reverse_top(input)
    open(input, "r+") do |f|
        lines = f.readlines
        f.rewind
        f.truncate(0)
        f.write lines[0]
    end
end
#reverse_top(ARGV[0])

# 1行末尾出力
def reverse_last(input)
    open(input, "r+") do |f|
        lines = f.readlines
        f.rewind
        f.truncate(0)
        f.write lines.reverse[0]
    end
end
#reverse_last(ARGV[0])

def tail(lines, file)
    queue = Array.new
    open(file) do |io|
        while line = io.gets
            queue.push(line)
            if queue.size > lines
                queue.shift
            end
        end
    end
    queue.each {|line| print line }
end

puts "==="
tail(10, __FILE__)

puts "==="
tail(3, __FILE__)

# Fileオブジェクトへの出力が何バイトまでバッファリングされるか調べるスクリプト
filename = "test.txt"
writen = 0

File.open(filename, "w") do |f|
    while writen < 100_000
        writen += 1
        f.write("a")
        size = File.size(filename)
        p [writen, size] if writen == size
    end
end
