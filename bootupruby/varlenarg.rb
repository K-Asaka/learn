#! /usr/local/bin/ruby
# -*- coding: utf-8 -*-
def some_method(a, b, *c)
  p [a, b, c]
end
some_method(1, 2, 3, 4, 5)

