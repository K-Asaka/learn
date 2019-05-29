#! /usr/bin/env python
# -*- coding: utf-8 -*-
import csv
csvfile = open("./11/test.csv", encoding="utf-8")
for row in csv.reader(csvfile):
    print(row)
