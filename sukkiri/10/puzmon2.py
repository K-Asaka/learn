'''
作成日: XXXX年YY月ZZ日
作成者: あいうえお
'''
# インポート

# グローバル変数の宣言

# 関数宣言
def do_battle(monster):
    is_win = 1
    print(monster + 'が現れた！')

    print(monster + 'を倒した！')
    return is_win

def go_dungeon(player):
    print(player + "はダンジョンに到達した")
    monsters = ['スライム', 'ゴブリン', 'オオコウモリ', 'ウェアフレア', 'ドラゴン']
    is_win = 0

    for monster in monsters:
        is_win += do_battle(monster)

    print(player + "はダンジョンを制覇した")
    return is_win

def main():
    print('*** Puzzle & Monsters ***')
    while True:
        player = input('プレイヤー名を入力してください> ')
        if player != '':
            break
        else:
            print('エラー：プレイヤー名を入力してください')            

    is_win = go_dungeon(player)

    if is_win < 5:
        print('*** GAME OVER!! ***')
    else:
        print('*** GAME CLEARED!! ***')
        print(f'倒したモンスター数={is_win}')

# main関数の呼び出し
main()
