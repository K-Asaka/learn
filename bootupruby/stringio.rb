#! /usr/local/bin/ruby
# -*- cording: utf-8 -*-
require 'stringio'
buffer = String.new
sio = StringIO.new(buffer)
$stderr = $stdout = sio
puts "untuh"
warn "outed"
$stdout = STDOUT
puts buffer

