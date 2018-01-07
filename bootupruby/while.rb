#! /usr/local/bin/ruby
# -*- coding: utf-8 -*-

condition = 0
while condition < 5 do
  condition = condition + 1
  puts condition
end


def more?
  gets.chomp != "ok"
end
begin
  $stdout.print "満足したら'ok'と入力してください:"
end while more?

