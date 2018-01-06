#! /usr/local/bin/ruby
# -*- coding: utf-8 -*-
def describe(name)
  puts "This is a #{name}."
  name[2] = ?p
  puts "This is a #{name}."
end
CATTLE = "yahoo"
describe(CATTLE)
p CATTLE

