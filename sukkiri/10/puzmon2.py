'''
作成日: XXXX年YY月ZZ日
作成者: あいうえお
'''
# インポート

# グローバル変数の宣言

# 関数宣言
def print_monster_name(monster):
    # monsterはディクショナリで受け取る
    # (1)モンスターの名前をキーnameで取得する
    # (2)
    # (3)
    
    monster_name = monster['name']

    # モンスター名を表示する
    print(f'{monster_name}', end='')


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
