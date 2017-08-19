# -*- coding:utf-8 -*-
'''
Created on 2017年6月15日

@author: Administrator
'''

# #默认参数的函数
# def repeat_str(str,times = 1):
#     repeated_strs = str * times
#     return repeated_strs
# #函数调用
# print(repeat_str("Hello"))#使用的是默认参数
# print(repeat_str("Hello ",5))#使用的是自定义的参数

# #关键字参数
# def function(a,b = 4,c = 8):
#     print("a is ",a,' and b is ',b,' and c is ',c)
# 
# function(13,17)
# function(125,c = 24)
# function(c = 40,a = 80)

#VarArgs参数  可变参数
def print_paras(fparas,*nums,**words):
    print("fparas: "+ str(fparas))
    print("nums: " + str(nums))
    print("words:" + str(words))
    
print_paras("Hello",1,3,5,7,words = "python",another_words = "java")