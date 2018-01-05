#! /usr/local/bin/ruby
# -*- cording: utf-8 -*-
File.open("time.log") {|f|
  f.each_line do |line|
    print "#{f.lineno}: #{line}"
  end
}

