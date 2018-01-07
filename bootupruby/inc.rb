#! /usr/local/bin/ruby
# -*- coding: utf-8 -*-
0.upto(9) {|i| puts i}
str = "Glubbdubdrib"
str.each_byte do |byte|
  printf "%x\n", byte
end

