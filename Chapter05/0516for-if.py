girls = ['かなこ', 'ゆう', 'ひでみ']
boys = ['ゆうへい', 'ひろし', 'かずき']
[b + '+' + g for b in boys for g in girls if b[0] == g[0]]
