#! /usr/local/bin/ruby
# -*- coding: utf-8 -*-
class Duration
  DAYS_OF_WEEK = 7
  p DAYS_OF_WEEK
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
  def print_days_of_week
    p DAYS_OF_WEEK
  end
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
p Duration::DAYS_OF_WEEK

class Duration    # 再オープン
  class << self
    def a_week_from(from)
      return self.new(from, from + 7 * 24 * 60 * 60)
    end
  end
end
p Duration.a_week_from(Time.now)

