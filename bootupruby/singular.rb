#! /usr/local/bin/ruby
# -*- coding: utf-8 -*-
message = "Hello"
def message.build_greeting(target)
  "#{self}, #{target}."
end
p message.build_greeting("world")
message2 = "Hello"
p message2.build_greeting("world")

