#! /usr/local/bin/ruby
# -*- coding: utf-8 -*-
catch(:exit) {
  loop do
    loop do
      throw :exit
    end
  end
}
puts "大域脱出"

