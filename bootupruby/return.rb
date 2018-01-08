#! /usr/local/bin/ruby
# -*- coding: utf-8 -*-
def fact(n)
  return 1 if n == 0
  product = 1
  (1 .. n).each do |i|
    product *= i
  end
  return product
end
# def fact(n); (1..n).inject(1) {|p,i| p*i} end

p fact(5)

