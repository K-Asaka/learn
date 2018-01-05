#! /usr/local/bin/ruby
# -*- cording: utf-8 -*-
File.open("bmode.log", File::WRONLY|File::CREAT) {|f|
  f.puts Time.now
}

