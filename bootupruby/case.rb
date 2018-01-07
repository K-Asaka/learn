#! /usr/local/bin/ruby
# -*- coding: utf-8 -*-
def do_something1
  puts "do something1"
end
def do_something2
  puts "do something2"
end
def do_something3
  puts "do something3"
end
def not_executed
  puts "not executed"
end
def do_something_other
  puts "do something other"
end

value = 5
array = [4, 5]
case value
when 1 then
  do_something1
when 2, 3 then
  do_something2
when 3
  not_executed
when *array
  do_something3
else
  do_something_other
end

