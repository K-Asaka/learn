#! /usr/local/bin/ruby
# -*- coding: utf-8 -*-
def method_with_side_effect
  puts "副作用が発生しました"
  return 1
end

puts "--- true || method ----"
true || method_with_side_effect
puts "--- false || method ----"
false || method_with_side_effect

