import json
import re
import time

import execjs
import requests


def trend_data(fund_code):
    res = requests.get(get_url(fund_code))
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
    for fund in fund_arr:
        print(fund)


def get_url(fs_code):
    head = 'http://fund.eastmoney.com/pingzhongdata/'
    tail = '.js?v=' + time.strftime("%Y%m%d%H%M%S", time.localtime())
    return head + fs_code + tail


def get_detail(fs_code):
    res = requests.get(get_url(fs_code))
    content = res.text

    # 使用execjs获取到相应的数据
    js_content = execjs.compile(content)

    # 基金持仓股票代码
    stockCodes = js_content.eval('stockCodes')
    print(stockCodes)

    # 规模变动 mom-较上期环比，资产规模：最后一条记录
    Data_fluctuationScale = js_content.eval('Data_fluctuationScale')
    print(Data_fluctuationScale)




if __name__ == '__main__':
    # all_fund()
    # trend_data('001594')
    get_detail('001594')
