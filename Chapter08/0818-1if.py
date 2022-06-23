def describe_person(person):
    print(f"{person['氏名']}に関する記述:")
    print(f"年齢: {person['年齢']}")
    if '職業' in person:
        print(f"職業: {person['職業']}")

person = {'氏名': '山田太郎', '年齢': 42, '職業': 'プログラマー'}
describe_person(person)
