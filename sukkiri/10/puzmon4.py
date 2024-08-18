'''
作成日: XXXX年YY月ZZ日
作成者: あいうえお
'''
# インポート
import random

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

def show_party(party):
    for friend in party['friends']:
        print_monster_name(friend)
        print(f" HP= {friend['hp']}", end=' ')
        print(f" 攻撃= {friend['ap']:2}", end=' ')
        print(f" 防御= {friend['dp']:2}")

def organize_party(player_name, friends):
    """
        引数
            player_name: プレイヤー名
            friends: 味方モンスターをディクショナリで管理したリスト
    """
    # (1)味方モンスターのHPの合計と防御力の平均を求める
    # (2)ディクショナリにパーティの情報をまとめる
    # (3)ディクショナリを戻り値に指定する

    max_hp = 0
    dp = 0

    for friend in friends:
        max_hp += friend['hp']
        dp += friend['dp']

    dp = int(dp / len(friends))
    hp = max_hp

    party = {
        "player_name": player_name,
        "friends": friends,
        "hp": hp,
        "max_hp": max_hp,
        "dp": dp
    }

    return party

def do_attack(monster, command):
    damage = hash(command) % 50
    damage += abs(damage - monster['dp']) + int(damage * random.uniform(0, 3))
    return damage

def do_enemy_attack(party, monster):
    damage = int(abs(monster['ap'] - party['dp']) * random.uniform(0, 3))
    return damage

def on_player_turn(party, monster):
    print(f"【{party['player_name']}のターン】(HP={party['hp']})")
    command = input('コマンド？ > ')
    damage = do_attack(monster, command)
    print(f'{damage}のダメージを与えた')
    monster['hp'] -= damage

def on_enemy_turn(party, monster):
    print(f"【{monster['name']}のターン】(HP={monster['hp']})")
    damage = do_enemy_attack(party, monster)
    print(f'{damage}のダメージを受けた')
    party['hp'] -= damage

def do_battle(party, monster):
    is_win = 0
    print_monster_name(monster)
    print('が現れた！')

    while party['hp'] > 0 and monster['hp'] > 0:
        on_player_turn(party, monster)

        if monster['hp'] > 0:
            on_enemy_turn(party, monster)
            if party['hp'] <= 0:
                print('パーティのHPが0になった')
        else:
            print_monster_name(monster)
            print('を倒した！')
            is_win = 1

    return is_win

def go_dungeon(party, monsters):
    print(party['player_name'] + f'のパーティ(HP={party['hp']})はダンジョンに到達した')
    print('＜パーティ編成＞-------------------')
    show_party(party)
    print('-' * 35, end='\n\n')
    is_win = 0

    for monster in monsters:
        is_win += do_battle(party, monster)
        if party['hp'] <= 0:
            print(f'{party['player_name']}はダンジョンから逃げ出した')
            break
        else:
            print(f'{party['player_name']}はさらに奥へと進んだ')
            print('=' * 35)
    
    if is_win == len(monsters):
        print(party['player_name'] + 'のパーティはダンジョンを制覇した')
    return is_win

def main():
    while True:
        player = input('プレイヤー名を入力してください> ')
        if player != '':
            break
        else:
            print('エラー：プレイヤー名を入力してください')
    
    print('*** Puzzle & Monsters ***')
    
    seiryu = {
        'name': '青龍',
        'hp': 150,
        'max_hp': 150,
        'element': '風',
        'ap': 15,
        'dp': 10
    }
    suzaku = {
        'name': '朱雀',
        'hp': 150,
        'max_hp': 150,
        'element': '火',
        'ap': 25,
        'dp': 10
    }
    byakko = {
        'name': '白虎',
        'hp': 150,
        'max_hp': 150,
        'element': '土',
        'ap': 20,
        'dp': 5
    }
    genbu = {
        'name': '玄武',
        'hp': 150,
        'max_hp': 150,
        'element': '水',
        'ap': 20,
        'dp': 15
    }
    friends = [seiryu, suzaku, byakko, genbu]
    party = organize_party(player, friends)

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

    is_win = go_dungeon(party, monsters)

    if is_win < 5:
        print('*** GAME OVER!! ***')
    else:
        print('*** GAME CLEARED!! ***')
    print(f'倒したモンスター数={is_win}')

# main関数の呼び出し
main()
