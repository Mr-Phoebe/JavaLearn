# -*- coding:utf-8 -*-
'''
Created on 2017年6月15日

@author: Administrator
'''
#Syntax Error 语法错误

# while True
#     print("Hello World")

#Exception Error
# print(hello * 4)
# print(8/0)
# num = 6
# print("Hello World " + num)

#处理异常
# while True:
#     try:
#         x = int(input("Please enter a number:"))
#         break
#     except ValueError:
#         print("Not valid input,try agin...")

#处理异常的另外一个例子
try:
    f = open('myfile.txt')
    s = f.readline()
    i = int(s.strip())
except OSError as err:
    print("OS error:{0}".format(err))
except ValueError:
    print("Could not convert data to an integer.")