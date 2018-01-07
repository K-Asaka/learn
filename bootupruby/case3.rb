#! /usr/local/bin/ruby
# -*- coding: utf-8 -*-
value = "3"
puts case value
when '0'          then '0'
when /\A\d\Z/     then '1けた'
when /\A\d{2}\Z/  then '2けた'
else                   'それ以外'
end

