# -*- coding:utf-8 -*-
'''
Created on 2017年6月15日

@author: Administrator
'''
#键值对
#创建字典
phone_book = {'Tom':123,'Jerry':456,'Kim':789}
mixed_dict = {'tom':'boy',11:23.5}

print("Tom has phone number:" + str(phone_book['Tom']))


#修改字典中的值
phone_book['Tom'] = 999
#字典中添加新的成员

phone_book['Heath'] = 888

print("The added book is :" + str(phone_book))

#删除字典元素，以及字典本身

del phone_book['Tom']
print("The deleted book is :" + str(phone_book))
phone_book.clear()
print("The added book is :" + str(phone_book))
#del phone_book
#print("The added book is :" + str(phone_book))

#字典中不允许出现同一个Key

rep_test = {'name':'aa','age':5,'name':'bb'}
print(rep_test)

#键是不可变的：可以用数字字符串或者元组充当键，不能用列表
list_dictionary = {('Name'):'jhon','age':13}

print(list_dictionary)

