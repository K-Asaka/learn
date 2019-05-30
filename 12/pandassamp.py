#! /usr/bin/env python
# -*- coding: utf-8 -*-
import numpy as np
import pandas as pd
reactions_in_ms = np.loadtxt('./12/reactions.txt')
reactions_in_sec = reactions_in_ms / 1000

reactions_df = pd.DataFrame(reactions_in_sec)
print(reactions_df.head())
print(reactions_df.describe())
