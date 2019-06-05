import pandas as pd
from string import Template

df = pd.read_excel(io='test.xlsx', converters={'a': str})
f = open('test.txt', 'a')
sl = []
s = Template("update t_invoice_conn_account set make_invoice_user = '$who' where organize_id = '$id';\n")
for index, row in df.iterrows():
    sl.append(s.substitute(who=row.d, id=row.a))
    f.write(s.substitute(who=row.d, id=row.a))
print(sl)
f.close()
