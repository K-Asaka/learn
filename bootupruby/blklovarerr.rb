#! /usr/local/bin/ruby
# -*- coding: utf-8 -*-

last_odd = nil    # これを消すとブロック内にしかlast_oddは存在しないため最後でエラーが出る
(1..10).each do |i|
  last_odd = i if i%2 != 0
end
p last_odd

