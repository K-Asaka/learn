#! /usr/local/bin/ruby
# -*- coding: utf-8 -*-
proc = Proc.new { puts "Proc was called" }
3.times(&proc)

