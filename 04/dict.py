#! /usr/bin/env python
# -*- coding: utf-8 -*-

rssitem = {"title"   : "Pythonの勉強前",
           "link"    : "http://host.to/blog/entry",
           "dc:date" : "2016-05-16T13:24:04Z"}
rssitem.update({"title"      : "Pythonを勉強中",
                "dc:creator" : "someone"})
print(rssitem.keys())
print(rssitem)

line = "I have a pen. you have a pen. Can you speak English?"
wordcount = {}
for word in line.split():
    wordcount[word] = wordcount.get(word, 0) + 1
#    if word in wordcount:
#        wordcount[word] = wordcount[word] + 1
#    else:
#        wordcount[word] = 1

print(wordcount)