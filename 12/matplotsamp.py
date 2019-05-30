#! /usr/bin/env python
# -*- coding: utf-8 -*-
import matplotlib.pyplot as plt
import numpy as np
reactions_in_ms = np.loadtxt('./12/reactions.txt')
reactions_in_sec = reactions_in_ms / 1000

h = plt.hist(reactions_in_sec)
plt.show()
