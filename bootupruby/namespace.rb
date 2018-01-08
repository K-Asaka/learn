#! /usr/local/bin/ruby
# -*- coding: utf-8 -*-
class Service; end
module Library
  class Service; end
end

p ::Service         # トップレベルのService
p Library::Service  # LibraryのService

