#! /usr/local/bin/ruby
# -*- coding: utf-8 -*-
p $stdin
p $stdout
p $stderr
$stderr.printf("%X\n", 0xcafe)

File.open("stdio.log", 'w') {|f|
  $stdout = f
  puts "Welcome to Glubbdubdrib"
  $stdout = STDOUT
}

