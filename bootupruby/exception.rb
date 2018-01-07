#! /usr/local/bin/ruby
# -*- coding: utf-8 -*-
def do_something
  puts "do something"
end

begin
  do_something
rescue ArgumentError => error then  # thenは省略可能
  puts error.message
rescue TypeError                    # 例外捕捉変数は省略可能
  # 何かの処理
rescue => another_error             # クラスは省略可能
  puts another_error.message
else
  puts "例外なし"                   # 例外がなかった場合
ensure
  puts "ensure節"
end

