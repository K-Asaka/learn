import openpyxl as px
from openpyxl.chart import BarChart, Reference

# ドリンク名
drinks = ['コーヒー', '紅茶', '緑茶', 'オレンジジュース', 'グレープジュース', '牛乳']

# 4～6月の月名
months = ['Apr', 'May', 'Jun']

# 各ドリンクの注文件数をdrinksの順番で列記
apr = [1250, 620, 175, 60, 35, 25]
may = [2005, 850, 310, 170, 185, 90]
jun = [1660, 750, 220, 225, 200, 120]

wbbr = px.Workbook()
wsbr = wbbr.active

wsbr.append(months)
wsbr.insert_cols(1)

for i in range(len(drinks)):
    wsbr.append([drinks[i], apr[i], may[i], jun[i]])

ch = BarChart()
ch.type = 'col'
ch.title = '第一期の飲料注文件数'
ch.x_axis.title = 'ドリンク'
ch.y_axis.title = '注文件数'
data = Reference(wsbr, min_col=2, min_row=1, max_col=4, max_row=7)
ch.add_data(data, titles_from_data=True)
ctgrs = Reference(wsbr, min_col=1, min_row=2, max_row=7)    # 列見出しの部分を指定
ch.set_categories(ctgrs)
wsbr.add_chart(ch, "E1")

wbbr.save('barchart.xlsx')
