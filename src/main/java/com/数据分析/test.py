import json
import pingouin as pg
import pandas as pd
from flask import Flask, request

app = Flask(__name__)


@app.route('/data', methods=['POST'])
def hello():
    data = request.get_data()
    data = data.decode('utf-8')
    data = json.loads(data)

    df = pd.DataFrame(data)
    df = df.dropna()
    df.head()

    # Cronbach's α系数
    cronbach, ar = pg.cronbach_alpha(data=df)
    print("Cronbach's α系数:", cronbach)

    # CITC
    a = df.corr(method='pearson', min_periods=1)
    print(a)

    return a


if __name__ == '__main__':
    app.run(port=8090)
