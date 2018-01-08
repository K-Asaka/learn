#! /usr/local/bin/ruby
# -*- coding: utf-8 -*-
def black_box_process(x, y)
  @c = x + y
  p "black_box_process() => ", @c
  nil
end

p "main => ", black_box_process(1, 2)

