#! /usr/local/bin/ruby
# -*- coding: utf-8 -*-
def my_map
  [yield(1), yield(2), yield(3)]
end

p my_map {|i| i+1}

