#! /usr/local/bin/ruby
# -*- coding: utf-8 -*-
class Foo
  include Comparable
  def <=>(rhs)
    # 何らかの実装
    p rhs
  end
end
foo1 = Foo.new
foo2 = Foo.new
foo1 <= foo2    # Comparableが提供

