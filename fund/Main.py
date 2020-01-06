import json

import requests
import re


def trend_data():
    res = requests.get('http://fund.eastmoney.com/pingzhongdata/001594.js?v=20191229155842')
    content = res.text

    data_list = content.split(';')
    data_list = [d for d in data_list]
    data_ac_worth = ''
    for d in data_list:
        comment_list = re.findall(r'/*.*/', d)
        comment = ''
        if len(comment_list) > 0:
            comment = str(comment_list[0])
            description = comment.replace('/*', '').replace('*/', '')
        value = d.replace(comment, '')
        print(comment)
        print(value)

        # 获取累计精致走势
        if 'Data_ACWorthTrend' in value:
            data_ac_worth = value.split('=')[1]

    data_ac_worth_list = json.loads(data_ac_worth)
    sorted(data_ac_worth_list, key=lambda s: s[0])
    # [print(time.strftime('%Y-%m-%d %H:%M:%S', time.localtime(worth[0] / 1000)), worth[1]) for worth in data_ac_worth_list]


def all_fund():
    res = requests.get('http://fund.eastmoney.com/js/fundcode_search.js')
    content = res.text

    fund_arr = json.loads(content.replace('var r = ', '').replace(';', ''))
    print(len(fund_arr))
    for fund in fund_arr:
        print(fund)

if __name__ == '__main__':
    all_fund()
    # trend_data()
