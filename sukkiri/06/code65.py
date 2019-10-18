# RPGの勇者を表すクラスの定義と利用
class Hero:
    name = '開発者'
    hp = 100
    def sleep(self, hours):
        print('{}は{}時間寝た！'.format(self.name, hours))
        self.hp += hours

# ゲーム開始
print('デス・マーチ　～無限作業の誘い～')
h = Hero()
h.sleep(3)
print('{}のHPは現在{}です'.format(h.name, h.hp))
