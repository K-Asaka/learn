#! /usr/local/bin/ruby
# -*- coding: utf-8 -*-
def foo_bar_baz2
  %w[ foo bar baz ].each do |item|
    yield item
  end
end

foo_bar_baz2 do |item|
  puts item
end


