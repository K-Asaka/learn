#! /usr/local/bin/ruby
# -*- coding: utf-8 -*-
def create_counter
  count = 1
  return Proc.new do
    count += 1
    p count
  end
end
counter = create_counter
p counter.class
counter.call
counter.call
counter2 = create_counter
counter2.call
counter.call
counter2.call

