#! /usr/local/bin/ruby
# -*- coding: utf-8 -*-
value = 3
puts case value
when 0      then '0'
when 1..9   then '1けた'
when 10..99 then '2けた'
end

