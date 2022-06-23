def describe_person(person):
    print(f"{person['氏名']}に関する記述:")
    print(f"年齢: {person['年齢']}")
    try:
        print(f"職業: {person['職業']}")
    except KeyError: pass

person = {'氏名': '山田太郎', '年齢': 42}
describe_person(person)
