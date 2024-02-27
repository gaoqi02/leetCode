import pingouin as pg
import pandas as pd

dataDict={}
dataDict["A"]= [10, 20, 30, 40, 50, 60, 1, 2, 3, 4, 5, 6]
dataDict["B"]= [11, 21, 31, 41, 51, 61, 1, 2, 3, 4, 5, 6]
df = pd.DataFrame(dataDict)

# df = pd.read_excel('/Users/didi/Downloads/test.xlsx', index_col=0)
df = df.dropna()
df.head()

# Cronbach's α系数
cronbach, ar = pg.cronbach_alpha(data=df)
print("Cronbach's α系数:", cronbach)

# CITC
a = df.corr(method='pearson', min_periods=1)
print(a)