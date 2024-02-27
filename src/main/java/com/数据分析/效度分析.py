import pandas as pd
import numpy as np
from sklearn import preprocessing
from factor_analyzer.factor_analyzer import calculate_kmo
from factor_analyzer.factor_analyzer import calculate_bartlett_sphericity

df = pd.read_excel('/Users/gaoqi/Documents/xinduxiaodutest/origin3.xlsx', index_col=0).iloc[:, :-3]
df = df.dropna()
df.head()

# kmo的逻辑
# kmo_all,kmo_total=calculate_kmo(df)
# print(kmo_total)

# Bartlett
statistic, p_value = calculate_bartlett_sphericity(df)
print(statistic)
print(p_value)

from factor_analyzer import FactorAnalyzer

# 因子分析
fa = FactorAnalyzer(n_factors=20, method='principal', rotation=None)

fa.fit(df)

variance, proportional_variance, cumulative_variances = fa.get_factor_variance()
print("特征根%s", variance)
print("方差解释率%s", proportional_variance)
print("累积百分比%s", cumulative_variances)

# 累积百分比第一个超过80%的
fan = FactorAnalyzer(n_factors=10, method='principal', rotation='varimax')
fan_variance, fan_proportional_variance, fan_cumulative_variances = fa.get_factor_variance()

# 变量个数*因子个数
print("旋转后因子载荷系数表%s", fa.loadings_)
