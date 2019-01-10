def traverse(path)
    Dir.glob(["#{path}/**/*", "#{path}/**/.*"]).each do |name|
        unless File.directory?(name)
            process_file(path)          # ファイルに対する処理
        end
    end
end

def process_file(path)
    puts path                       # ひとまず出力するだけ
end

traverse(ARGV[0])
