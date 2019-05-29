#! /usr/bin/env python
# -*- coding: utf-8 -*-
import csv

seq = 'I have a pen.'

csvfile2 = open("./11/test2.csv", "w", encoding="utf-8")
writer = csv.writer(csvfile2)
for row in seq:
    writer.writerow(row)
