#! /usr/local/bin/ruby
# -*- coding: utf-8 -*-
value = 3
puts case value
when 0      then '0'
when 1..9   then '1けた'
when 10..99 then '2けた'
end

# case比較演算子
# 上記コードとほぼ同義
if 0 === value then
  puts '0'
elsif (1..9) === value then
  puts '1けた'
elsif (10..99) === value then
  puts '2けた'
end

