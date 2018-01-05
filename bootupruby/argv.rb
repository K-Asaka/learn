#! /usr/local/bin/ruby
# -*- coding: utf-8 -*-
expression = ARGV.join(' + ')
total = ARGV.inject(0){|subtotal, arg| subtotal + arg.to_i}
puts "#{expression} = #{total}"

