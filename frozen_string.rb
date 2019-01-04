# frozen-string-literal: true
# 実行時、rubyコマンドに「--enable=frozen-string-literal」をつけても同じ効果

str = "Ruby"
p str.upcase!
