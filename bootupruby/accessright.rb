#! /usr/local/bin/ruby
# -*- coding: utf-8 -*-
class Yapoo
  # デフォルトではメソッドはpublicになる
  def public_method; puts "public_method" end

  private   # 以降に定義するメソッドは自動的にprivateになる
  def internal_use; puts "internal_use" end
  def public_api
    return internal_use
  end
  public :public_api
end

yapoo = Yapoo.new
yapoo.public_method
yapoo.public_api

