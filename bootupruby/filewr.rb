#! /usr/local/bin/ruby
# -*- cording: utf-8 -*-
File.open("time.log", 'a') {|f|
  f.puts Time.now
}

