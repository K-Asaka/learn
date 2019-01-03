file = ARGV[0]
begin
    io = File.open(file)
rescue
    sleep 10
    retry
end

data = io.read
io.close
