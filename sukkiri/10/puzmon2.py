'''
作成日: XXXX年YY月ZZ日
作成者: あいうえお
'''
# インポート

# グローバル変数の宣言
ELEMENT_SYMBOLS = {
    '火': '$',
    '水': '~',
    '風': '@',
    '土': '#',
    '命': '&',
    '無': ' '
}
ELEMENT_COLORS = {
    '火': '31',
    '水': '36',
    '風': '32',
    '土': '33',
    '命': '35',
    '無': '37'
}

# 関数宣言
def print_monster_name(monster):
    # monsterはディクショナリで受け取る
    # (1)モンスターの名前と属性を取得する
    # (2)取得した属性に対応する記号をELEMENT_SYMBOLSから取得する
    # (3)取得した属性に対応する記号をELEMENT_COLORSから取得する
    
    monster_name = monster['name']
    symbol = ELEMENT_SYMBOLS[monster['element']]
    color = ELEMENT_COLORS[monster['element']]

    # モンスター名を表示する
    print(f'\033[{color}m{symbol}{monster_name}{symbol}\033[0m ', end='')


def do_battle(monster):
    is_win = 1
    print_monster_name(monster)
    print('が現れた！')

    print_monster_name(monster)
    print('を倒した！')
    return is_win

def go_dungeon(player, monsters):
    print(player + "はダンジョンに到達した")
    is_win = 0

    for monster in monsters:
        is_win += do_battle(monster)

    print(player + "はダンジョンを制覇した")
    return is_win

def main():
    print('*** Puzzle & Monsters ***')
    slime = {
        'name': 'スライム',
        'hp': 100,
        'max_hp': 100,
        'element': '水',
        'ap': 10,
        'dp': 1
    }
    goblin = {
        'name': 'ゴブリン',
        'hp': 200,
        'max_hp': 200,
        'element': '土',
        'ap': 20,
        'dp': 5
    }
    giantbat = {
        'name': 'オオコウモリ',
        'hp': 300,
        'max_hp': 300,
        'element': '風',
        'ap': 30,
        'dp': 10
    }
    werewolf = {
        'name': 'ウェアウルフ',
        'hp': 400,
        'max_hp': 400,
        'element': '風',
        'ap': 40,
        'dp': 15
    }
    dragon = {
        'name': 'ドラゴン',
        'hp': 600,
        'max_hp': 600,
        'element': '火',
        'ap': 50,
        'dp': 20
    }
    monsters = [slime, goblin, giantbat, werewolf, dragon]

    while True:
        player = input('プレイヤー名を入力してください> ')
        if player != '':
            break
        else:
            print('エラー：プレイヤー名を入力してください')            

    is_win = go_dungeon(player, monsters)

    if is_win < 5:
        print('*** GAME OVER!! ***')
    else:
        print('*** GAME CLEARED!! ***')
        print(f'倒したモンスター数={is_win}')

# main関数の呼び出し
main()
