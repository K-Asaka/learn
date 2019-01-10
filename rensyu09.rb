def print_libraries
    $:.each do |path|
        next unless FileTest.directory?(path)
        Dir.open(path) do |dir|
            dir.each do |name|
                if name =~ /\.rb$/i
                    puts name
                end
            end
        end
    end
end
print_libraries

# rbconfigライブラリから、この拡張子を取得して拡張ライブラリにも対応させたバージョン
require "rbconfig"

def lprint_libraries
    $:.each do |path|
        next unless FileTest.directory?(path)
        dlext = RbConfig::CONFIG["DLEXT"]
        Dir.open(path) do |dir|
            dir.each do |name|
                if name =~ /\.rb$/i || name =~ /\.#{dlext}$/i
                    puts name
                end
            end
        end
    end
end
lprint_libraries

require "find"

def du(path)
    result = 0
    Find.find(path) do |f|
        if File.file?(f)
            result += File.size(f)
        end
    end
    printf("%d %s\n", result, path)
    return result
end

du(ARGV[0] || ".")
