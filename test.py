import re
import pymysql
from string import Template
import smtplib
from email.mime.text import MIMEText
import time
# import os
# import glob

# f = open('long_text_2019-05-08-00-07-18.txt')
# delList = []
# s = f.read()
# f.close()
# pattern = re.compile(r'\d+')
# result = pattern.findall(s)
# result.append('33050161749500000145')
# result.append('95200155300001827')
# result.append('95200155300001798')
# db = pymysql.connect("115.29.10.121", "root", "dpjA8Z6XPXbvos", "sfs-server")
# cursor = db.cursor()
# for account in result:
#     # print(type(account))
#     sql = "SELECT * from t_channel_config where channel_account = '" + account + "'"
#     cursor.execute(sql)
#     data = cursor.fetchone()
#     if data is None:
#         delList.append(account)
# db.close()
# for value in delList:
#     result.remove(value)
# print(len(result))
# file = open('data.txt')
# s = file.read()
# pattern = re.compile(r'\d+')
# result = pattern.findall(s)
# print(len(result))
# file.close()
# db = pymysql.connect("115.29.10.121", "root", "dpjA8Z6XPXbvos", "sfs-server")
# cursor = db.cursor()
# for account in result:
#     sql = "INSERT INTO `sfs-server`.`t_capital_query_config`( `busi_type`, `config_detail`, `config_type`, `gmt_create`, `create_user_id`, `create_user_name`, `gmt_modified`, `modified_user_id`, `modified_user_name`, `is_deleted`, `status`) VALUES ( '0000001', '" + account + "', '0', '2019-04-15 14:36:35', '', '', '2019-05-06 12:00:41', NULL, NULL, 0, '0')"
#     cursor.execute(sql)
# db.commit()
# db.close()


# t = Template('Return the $item to $owner.')
# d = dict(item='unladen swallow')
#
# print(t.safe_substitute(d))
# print(os.getcwd())
# os.chdir('/usr/local')
# print(os.getcwd())
#
# print(glob.glob('*'))
mail_user = "787378146"
mail_postfix = "qq.com"
me = mail_user + "<" + mail_user + "@" + mail_postfix + ">"
start = time.strptime('2017-04-03', '%Y-%m-%d')
print(start)
num = (time.time() - time.mktime(start)) // (3600 * 24)
print(num)
# msg = MIMEText('test')
# msg['Subject'] = 'sub'
# msg['From'] = me
# msg['To'] = "787378146@qq.com"
# print(msg.as_string())
#
# server = smtplib.SMTP('smtp.qq.com')
# server.login('787378146@qq.com', 'rvsfvrczuytmbgac')
# server.sendmail('787378146@qq.com', '1424749594@qq.com', msg.as_string())
# server.quit()
