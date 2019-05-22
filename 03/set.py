#! /usr/bin/env python
# -*- coding: utf-8 -*-

dice = {1, 2, 3, 4, 5, 6}
coin = {"表", "裏"}

print(dice)
print(coin)

prime = {2, 3, 5, 7, 13, 17}
fib = {1, 1, 2, 3, 5, 8, 13}

prime_fib = prime | fib
print(prime_fib)

dice = {1, 2, 3, 4, 5, 6}
even = {2, 4, 6, 8, 10}

odd_dice = dice - even
print(odd_dice)

prefs = {"北海道", "青森", "秋田", "岩手"}
capitals = {"札幌", "青森", "秋田", "盛岡"}

pref_cap = prefs & capitals
print(pref_cap)

pref_cap2 = prefs ^ capitals
print(pref_cap2)

# リストをsetに変換する
codon = ['ATG', 'GGC', 'TCC', 'AAG', 'TTC', 'TGG', 'GAC', 'TCC']
s_codon = set(codon)
print(len(codon), len(s_codon))
