#! /usr/local/bin/ruby
# -*- coding: utf-8 -*-
def foo_bar_baz3
  # ブロックを与えられていないとき、enum_forでEnumeratorを生成して返す
  return enum_for(:for_bar_baz3) unless block_given?
  %w[ foo bar baz ].each do |item|
    yield item
  end
end

p foo_bar_baz3
foo_bar_baz3 do |item|
  puts item
end

