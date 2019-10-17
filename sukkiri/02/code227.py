# セットの&演算
member_hobbies = {
    '開発者': {'SNS', '麻雀', '自転車'},
    '分析者': {'麻雀', '食べ歩き', '数学', '数学', '数学'}
}
common_hobbies = member_hobbies['開発者'] & member_hobbies['分析者']
print(common_hobbies)
