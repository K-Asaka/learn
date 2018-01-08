#! /usr/local/bin/ruby
# -*- coding: utf-8 -*-
b = binding
while code = gets
  p eval(code, b)
end

