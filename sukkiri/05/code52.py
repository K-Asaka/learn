# 見通しがよくなったプログラム
# 得点を入力
kai_scores = input_scores('開発者')
bun_scores = input_scores('分析者')
# 平均点を計算
kai_avg = calc_average(kai_scores)
bun_avg = calc_average(bun_scores)
# 結果を出力
output_result('開発者', kai_avg)
output_result('分析者', bun_avg)
