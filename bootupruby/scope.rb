#! /usr/local/bin/ruby
# -*- coding: utf-8 -*-
def next_of(origin)
  value = origin + 1
  p value
end

def prev_of(origin)
  value = origin - 1
  p value
end

next_of(2)
next_of(2)
prev_of(2)
#p value
#p undefined_variable

class Duration
  attribute_names = %w[days hours minutes seconds ]
  p attribute_names
  attribute_names.each do |name|
    attr_accessor name
  end
end
duration = Duration.new
#p attribute_names

