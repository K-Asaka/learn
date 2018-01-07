#! /usr/local/bin/ruby
# -*- coding: utf-8 -*-
1.upto(3) do |i|
  puts i
  redo if i == 2
end

