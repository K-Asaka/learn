#! /usr/bin/evn python
# -*- coding: utf-8 -*-

orig_str = "よのなかねかおかおかねかなのよ"
str_list = list(orig_str)
str_list.reverse()
print("".join(str_list) == orig_str)

orig_str = "おかしがすきすきすがしかお"
print("".join(reversed(orig_str)) == orig_str)

