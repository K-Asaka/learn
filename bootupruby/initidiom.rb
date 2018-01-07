#! /usr/local/bin/ruby
# -*- coding: utf-8 -*-
def generate_default_value
  p 'default value generated'
  return 'default value'
end
def some_method(param = nil)
  param ||= generate_default_value
  # ...paramを使って何かする
end

puts "nil"
some_method(nil)
puts "false"
some_method(false)
puts "true"
some_method(true)
puts "0"
some_method(0)
puts "()"
some_method()

