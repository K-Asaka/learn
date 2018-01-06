#! /usr/local/bin/ruby
# -*- coding: utf-8 -*-
File.open("time.log") {|f|
  f.each_line do |line|
    print "#{f.lineno}: #{line}"
  end
}

