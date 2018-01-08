#! /usr/local/bin/ruby
# -*- coding: utf-8 -*-
def foo_bar_baz
  yield "foo"
  yield "bar"
  yield "baz"
end

foo_bar_baz do |item|
  puts item
end

