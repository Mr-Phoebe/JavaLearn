# -*- coding:utf-8 -*-
'''
Created on 2017年6月15日

@author: Administrator
'''
#print换行符还是用\n与C/C++相同
from traceback import print_list
# print("你好\nWho am I?")

#创建元组
number_tuple = (1,2,3,4,5,6,7,8,9)
#print 的输出需要相同的类型，所以把number_list 转换成string形式
#创建string_tuple
string_tuple = ("abc","bbc","Python")
#创建mixed_tuple
mixed_tuple = ("Python",1,2,3,"I Love You")

# print("mixed_list:\n"+str(mixed_list))


#访问列表中的元素
second_number = number_tuple[1]
print(second_number)

third_string = string_tuple[2]

print(third_string)

fourth_mixed = mixed_tuple[3]
print(fourth_mixed)

print("second_num:{0} \nthird_string:{1} \nfourth_mix:{2}".format(second_number,third_string,fourth_mixed))
print(number_tuple)
del number_tuple
#print(number_tuple)


#更新列表中的元素

# number_tuple[1] = 30
# 
# print("number_list after: " + str(number_tuple))
# 
# #删除list中的内容
# del number_tuple[1]
# 
# print("number_list del after:"+str(number_tuple))
# 
# 
# #python 脚本语言
# 
print(len((1,2,3)))#长度
print((1,2,3)+(4,5,6))#组和
print(('Hello '*4))#重复
print(3 in(1,2,3))#查找
# 
# 元组的截取
abcd_tuple = ('a','b','c','d')
print(abcd_tuple[1])
print(abcd_tuple[-2])
print(abcd_tuple[1:])