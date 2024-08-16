'''
作成日: XXXX年YY月ZZ日
作成者: あいうえお
'''
# インポート

# グローバル変数の宣言

# 関数宣言
def go_dungeon(player):
    print(player + "はダンジョンに到達した")

    print(player + "はダンジョンを制覇した")
    return 5

def main():
    print('*** Puzzle & Monsters ***')
    player = "あいうえお"

    result = go_dungeon(player)
    print('*** GAME CLEARED!! ***')
    print(f'倒したモンスター数={result}')

# main関数の呼び出し
main()
