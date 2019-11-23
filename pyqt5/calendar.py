from PyQt5.QtWidgets import QCalendarWidget, QApplication
from PyQt5.QtCore import QDate

def myfunc():
    dt = calendar.selectedDate()
    print(dt.toPyDate())

# カレンダー作成
app = QApplication.instance()
if (app is None):
    app = QApplication([])

calendar = QCalendarWidget()
calendar.setGridVisible(True)
calendar.setGeometry(600, 400, 450, 350)
calendar.setWindowTitle('日付を選択')

# カレンダーの日付クリックで呼び出す関数を設定
calendar.clicked[QDate].connect(myfunc)

# カレンダー表示
calendar.show()
app.exec_()
