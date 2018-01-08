#! /usr/local/bin/ruby
# -*- coding: utf-8 -*-
class String
  # カエサル暗号を施すメソッドを追加する
  def caesar; tr 'a-zA-Z', 'n-za-mN-ZA-M' end
end
puts "Learning Ruby".caesar

