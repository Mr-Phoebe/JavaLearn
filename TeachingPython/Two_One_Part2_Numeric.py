'''
Created on 2017年6月15日

@author: Administrator
'''
#Python 中Numeric Types 的 学习使用
import sys
a = 3
b = 4
c = a + b

c = 7.0

d = 8.8



e =complex(c,d)
f = complex(float(a),float(b))

print("a is type:",type(a))
print("e is type:",type(e))
print("c is type:",type(c))

print("e + f = ",e + f)
print("e = ",e)
print("c = ",c)
print(b/a)
print(int(b/a))

print(b//a)
print("a + b = ",a + b)

print(sys.float_info)