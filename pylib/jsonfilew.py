import json

d = {
    'name': '鈴木義和',
    'age': 33,
    'sex': '男性'
}

with open('txtfiles/sample5.json', 'w', encoding='utf-8') as f:
    json.dump(d, f, ensure_ascii=False, indent=4)
