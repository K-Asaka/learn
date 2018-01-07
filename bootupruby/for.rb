#! /usr/local/bin/ruby
# -*- coding: utf-8 -*-

for i in [1, 2, 3] do
  puts i
end

[1, 2, 3].each do |i|
  puts i
end

# 要素が多値である場合は多重代入に準じる
for name, num in [ ['Jan', 1], ['Feb', 2] ]
  puts "#{name}は #{num}月"
end

