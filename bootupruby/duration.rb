#! /usr/local/bin/ruby
# -*- coding: utf-8 -*-
class Duration
  def initialize(since, till)
    @since = since
    @until = till
  end
  attr_accessor :since, :until
  def self.print(x); p x end
  def display; puts self end
end
duration = Duration.new(Time.now, Time.now + 3600)
p duration.until
p duration.since
p duration.since = Time.now
p duration.since
duration.display
Duration.print 1

