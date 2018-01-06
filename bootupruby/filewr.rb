#! /usr/local/bin/ruby
# -*- coding: utf-8 -*-
File.open("time.log", 'a') {|f|
  f.puts Time.now
}

