#! /usr/local/bin/ruby
# -*- coding: utf-8 -*-

(1..10).each do |i|
  last_odd = i if i%2 != 0
end
p last_odd

