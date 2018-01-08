#! /usr/local/bin/ruby
# -*- coding: utf-8 -*-
class Duration
  def initialize(since, till)
    @since = since
    @until = till
  end
  attr_accessor :since, :until
  def self.print(x); p x end
  def display(target=$>)
    super
    target.write "(#{self.since}-#{self.until})"
  end
  def print_since; p @since end
end
duration = Duration.new(Time.now, Time.now + 3600)
p duration.until
p duration.since
p duration.since = Time.now
p duration.since
duration.display
Duration.print 1
duration1 = Duration.new(Time.now - 7, Time.now)
duration2 = Duration.new(Time.now + 7, Time.now + 14)
duration1.print_since
duration2.print_since

