# -*- coding:utf-8 -*-
'''
Created on 2017年6月15日

@author: Administrator
'''
# #定义函数
# def say_hi():
#     print("Hi")
#     
# #调用函数
# say_hi()
# say_hi()
# 
# #有参函数,无返回值
# def print_sum_two(a,b):
#     c = a + b
#     print(c)
# print_sum_two(3,6)
# 
# #有参函数,没有返回值
# def hello_some(str):
#     print("hello " + str +"!")
#     
# hello_some("china")
# hello_some("world")
# #有参函数有返回值
# def repeat_str(str,times):
#     repeated_strs = str *times
#     return repeated_strs
# 
# repeated_strings = repeat_str("hello ",5)
# 
# print(repeated_strings)


# x = 60
# 
# def foo(x):
#     print("x is" + str(x))
#     x = 3
#     print("change local x to " + str(x))
#     
# foo(x)
# print('x is still '+str(x))

x = 60
def foo():
    global x
    print("x is" + str(x))
    x = 3
    print("change local x to " + str(x))  
foo()
print('x is still '+str(x))