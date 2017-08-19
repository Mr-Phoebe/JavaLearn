# -*- coding:utf-8 -*-
'''
Created on 2017年6月15日

@author: Administrator
'''

#Python Object-Oriented example
#类的定义：类的名字第一个字母大写
# class Student:
#     def __init__(self,name,grade):
#         self.name = name
#         self.grade = grade
#         
#     def introduce(self):
#         print("hi! I am "+ self.name)
#         print("my grade is : "+str(self.grade))
#         
#     def improve(self,amount):
#         self.grade = self.grade + amount
#         
# jim = Student('jim',86)
# jim.introduce()
# 
# jim.improve(10)
# jim.introduce()

#Python 装饰器
# def add_candles(cake_func):
#     def insert_candles():
#         return cake_func() + " candles"
#     return insert_candles
# 
# def make_cake():
#     return "cake"
# gift_func = add_candles(make_cake)
# 
# print(make_cake())
# print(gift_func())


# def add_candles(cake_func):
#     def insert_candles():
#         return cake_func() + " candles"
#     return insert_candles
# 
# def make_cake():
#     return "cake"
# make_cake = add_candles(make_cake)
# 
# print(make_cake())
# # print(gift_func())


def add_candles(cake_func):
    def insert_candles():
        return cake_func() + " candles"
    return insert_candles

@add_candles
def make_cake():
    return "cake"
#gift_func = add_candles(make_cake)

print(make_cake())
#print(gift_func())