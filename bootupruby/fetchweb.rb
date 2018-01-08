#! /usr/local/bin/ruby
# -*- coding: utf-8 -*-
require 'open-uri'
open("http://www.cabezfactory.net") {|connection|
  connection.each_line do |line|
    print line
  end
}

