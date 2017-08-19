'''
Created on 2017年6月15日

@author: Administrator
'''
import os
import requests
print(os.getcwd())

r = requests.get("http://www.sougou.com")

print(r.url)
print(r.encoding)
print(r.text)