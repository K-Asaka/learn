#! /usr/bin/env python
# -*- coding: utf-8 -*-
import numpy as np
reactions_in_ms = np.loadtxt('./12/reactions.txt')

print(reactions_in_ms.size)
print(reactions_in_ms[:20])

reactions_in_sec = reactions_in_ms / 1000
print(reactions_in_sec[:20])

print("平均値：", np.mean(reactions_in_sec))
print("中央値：", np.median(reactions_in_sec))
print("標準偏差：", np.std(reactions_in_sec))
print("最小値：", np.min(reactions_in_sec))
print("最大値：", np.max(reactions_in_sec))
